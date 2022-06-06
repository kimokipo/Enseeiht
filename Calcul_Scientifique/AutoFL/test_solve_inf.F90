program test_solve

  implicit none

  integer :: i, j, ierr, n
  double precision, dimension (:,:), allocatable :: L
  double precision, dimension (:), allocatable :: x, b
  double precision erreur_left
  double precision erreur_right
  double precision backward_error
  real :: start, finish

  write(*,*) 'n?'
  read(*,*) n

  ! Initialization: L is lower triangular
  write(*,*) 'Initialization...'
  write(*,*)
  
  allocate(L(n,n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate L(n,n) with n=',n
    goto 999
  end if

  allocate(x(n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate x(n) with n=',n
    goto 999
  end if

  allocate(b(n), stat=ierr)
  if(ierr.ne.0) then
    write(*,*)'Could not allocate b(n) with n=',n
    goto 999
  end if

  L = 0.D0
  do i = 1, n  
    L(i,i) = n + 1.D0
    do j = 1, i-1
      L(i,j) = 1.D0
    end do
  end do
  b = 1.D0

  ! Left-looking triangular solve of Lx=b
  write(*,*) 'Solving with a left-looking method...'

  call cpu_time(start)
    call left_looking_solve(L,x,b,n)
  call cpu_time(finish)
  
  if (n.le.10) then
    write(*,*) 'x_left = '
    write(*,*) x
  end if
  erreur_left = backward_error(L,x,b,n)

  write(*,*) 'erreur_left = ' 
  write(*,*) erreur_left 
  
  print '("Time_left = ",f6.3," seconds.")',finish-start
 
  ! Right-looking triangular solve of Lx=b
  write(*,*) 'Solving with a right-looking method...'

    call cpu_time(start)
        call right_looking_solve(L,x,b,n)
    call cpu_time(finish)
  
  if (n.le.10) then
    write(*,*) 'x_right = '
    write(*,*) x
  end if

  erreur_right = backward_error(L,x,b,n)

  write(*,*) 'erreur_right = ' 
  write(*,*) erreur_right 

  print '("Time_right = ",f6.3," seconds.")',finish-start


999 if(allocated(L)) deallocate(L)
    if(allocated(x)) deallocate(x)
    if(allocated(b)) deallocate(b)

end program test_solve

subroutine left_looking_solve(L,x,b,n)
    integer :: i,j
    integer ,intent(in) :: n
    double precision, intent(in),dimension (1:n,1:n) :: L
    double precision, intent(in),dimension (1:n) :: b
    double precision, dimension (1:n) :: x
	x = b
	do j =1, n
		do i = 1,(j-1)
			x(j) = x(j) - L(j,i)*x(i)
		end do
		x(j) = x(j) / L(j,j)
	end do
    return
end subroutine left_looking_solve
subroutine right_looking_solve(L,x,b,n)
    integer :: i,j
    integer ,intent(in) :: n
    double precision, intent(in),dimension (1:n,1:n) :: L
    double precision, intent(in),dimension (1:n):: b
    double precision, dimension (1:n) :: x
	x = b
	do j =1, n
		x(j) = x(j) / L(j,j)
		do i = (j+1),n
			x(i) = x(i) - L(i,j)*x(j)
		end do
	end do
    return
end subroutine right_looking_solve
double precision function backward_error(L,x,b,n)
    integer :: i,j,k
    integer ,intent(in) :: n
    double precision,intent(in), dimension (1:n,1:n) :: L
    double precision, intent(in),dimension (1:n) :: x, b
	double precision :: s1,s2,s
    s1 = 0.0
    s2 = 0.0
    s = 0.0
	do i = 1,n
		s = 0.0
		do j = 1,n
			s = s + L(i,j)*x(j)
        end do
		s1 = s1 + (s - b(i))*(s - b(i))
    end do
	s1 = sqrt(s1)
	do k= 1,n
		s2 = s2+b(k)*b(k)
	end do
	s2 = sqrt(s2)
    backward_error = s1/s2
	return 	
end function backward_error

! Pour n = 20000 la résolution triangulaire avec report(right) est plus performant que la résolution triangulaire sans report(left), puisque elles ont la mème erreur 2.3967453667628113E-015, et les temps : 0.143 seconds < 3.370 seconds, respectivement.
