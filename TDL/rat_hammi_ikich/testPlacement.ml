

open Compilateur
open PasseTdsRat
open PasseTypeRat
open PassePlacementRat
open Passe

(* Return la liste des adresses des variables d'un programme RAT *)
let getListeDep ratfile =
  let input = open_in ratfile in
  let filebuf = Lexing.from_channel input in
  try
    let ast = Parser.main Lexer.token filebuf in
    let tast = PasseTdsRat.analyser ast in
    let tyast = PasseTypeRat.analyser tast in
    let past = PassePlacementRat.analyser tyast in
    let listeAdresses = PasseVerifPlacement.analyser past in
    listeAdresses
  with
  | Lexer.Error _ as e ->
      report_error ratfile filebuf "lexical error (unexpected character).";
      raise e
  | Parser.Error as e->
      report_error ratfile filebuf "syntax error.";
      raise e

(* teste si dans le fichier fichier, dans la fonction fonction (main pour programme principal)
la occ occurence de la variable var a l'adresse dep[registre]
*)
let test fichier fonction (var,occ) (dep,registre) = 
  let l = getListeDep fichier in
  let lmain = List.assoc fonction l in
  let rec aux i lmain = 
    if i=1 
    then
      let (d,r) = List.assoc var lmain in 
      (d=dep && r=registre) 
    else 
      aux (i-1) (List.remove_assoc var lmain)
  in aux occ lmain

(**** sans fonctions ****)

(*
let%test "test2_x" = 
  test "../../fichiersRat/src-rat-placement-test/test2.rat"  "main" ("x",1)  (0,"SB")

let%test "test2_y" = 
  test "../../fichiersRat/src-rat-placement-test/test2.rat"  "main" ("y",1) (1,"SB")

let%test "test2_z" = 
  test "../../fichiersRat/src-rat-placement-test/test2.rat"  "main" ("z",1)  (2 ,"SB")

let%test "test3_x" = 
  test "../../fichiersRat/src-rat-placement-test/test3.rat"  "main" ("x",1)  (0, "SB")

let%test "test3_y" = 
  test "../../fichiersRat/src-rat-placement-test/test3.rat"  "main" ("y",1)  (1, "SB")

let%test "test3_z" = 
  test "../../fichiersRat/src-rat-placement-test/test3.rat"  "main" ("z",1)  (2, "SB")

let%test "test4_x" = 
  test "../../fichiersRat/src-rat-placement-test/test4.rat"  "main" ("x",1)  (0, "SB")
  
let%test "test4_y" = 
  test "../../fichiersRat/src-rat-placement-test/test4.rat"  "main" ("y",1)  (1, "SB")
  
let%test "test4_z" = 
  test "../../fichiersRat/src-rat-placement-test/test4.rat"  "main" ("z",1)  (2, "SB")

let%test "test5_x" = 
  test "../../fichiersRat/src-rat-placement-test/test5.rat"  "main" ("x",1)  (0, "SB")
  
let%test "test5_y" = 
  test "../../fichiersRat/src-rat-placement-test/test5.rat"  "main" ("y",1)  (1, "SB")
  
let%test "test5_z" = 
  test "../../fichiersRat/src-rat-placement-test/test5.rat"  "main" ("z",1)  (2, "SB")

let%test "test6_x_1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("x",1)  (0, "SB")
  
let%test "test6_y_1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("y",1)  (1, "SB")
  
let%test "test6_z_1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("z",1)  (2, "SB")

let%test "test6_x_2" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("x",2)  (3, "SB")
  
let%test "test6_y_2" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("y",2)  (4, "SB")
  
let%test "test6_z_2" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("z",2)  (5, "SB")

let%test "test6_x_3" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("x",3)  (3, "SB")
  
let%test "test6_y_3" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("y",3)  (4, "SB")
  
let%test "test6_z_3" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("z",3)  (5, "SB")

let%test "test6_x1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("x1",1)  (3, "SB")
  
let%test "test6_y1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("y1",1)  (4, "SB")
  
let%test "test6_z1" = 
  test "../../fichiersRat/src-rat-placement-test/test6.rat"  "main" ("z1",1)  (5, "SB")

let%test "test7_x_1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("x",1)  (0, "SB")
    
let%test "test7_y_1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("y",1)  (1, "SB")
    
let%test "test7_z_1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("z",1)  (2, "SB")
  
let%test "test7_x_2" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("x",2)  (3, "SB")
    
let%test "test7_y_2" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("y",2)  (4, "SB")
    
let%test "test7_z_2" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("z",2)  (5, "SB")
  
let%test "test7_x1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("x1",1)  (3, "SB")
    
let%test "test7_y1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("y1",1)  (4, "SB")
    
let%test "test7_z1" = 
  test "../../fichiersRat/src-rat-placement-test/test7.rat"  "main" ("z1",1)  (5, "SB")

(**** avec fonctions ****)

let%test "test8_x_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("x",1)  (0, "SB")
    
let%test "test8_y_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("y",1)  (1, "SB")
    
let%test "test8_z_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("z",1)  (3, "SB")
  
let%test "test8_x_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("x",2)  (4, "SB")
    
let%test "test8_y_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("y",2)  (5, "SB")
    
let%test "test8_z_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("z",2)  (7, "SB")
  
let%test "test8_x1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("x1",1)  (4, "SB")
    
let%test "test8_y1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("y1",1)  (5, "SB")
    
let%test "test8_z1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "main" ("z1",1)  (7, "SB")

let%test "test8_f_x_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("x",1)  (3, "LB")
    
let%test "test8_f_y_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("y",1)  (4, "LB")
    
let%test "test8_f_z_1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("z",1)  (5, "LB")
  
let%test "test8_f_x_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("x",2)  (6, "LB")
    
let%test "test8_f_y_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("y",2)  (7, "LB")
    
let%test "test8_f_z_2" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("z",2)  (8, "LB")
  
let%test "test8_f_x1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("x1",1)  (6, "LB")
    
let%test "test8_f_y1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("y1",1)  (7, "LB")
    
let%test "test8_f_z1" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("z1",1)  (8, "LB")
    
let%test "test8_f_a" = 
  test "../../fichiersRat/src-rat-placement-test/test8.rat"  "f" ("a",1)  (-1, "LB")
    
let%test "test9_f_a" = 
  test "../../fichiersRat/src-rat-placement-test/test9.rat"  "f" ("a",1)  (-1, "LB")

let%test "test10_f_a" = 
  test "../../fichiersRat/src-rat-placement-test/test10.rat"  "f" ("a",1)  (-1, "LB")

let%test "test11_f_a" = 
  test "../../fichiersRat/src-rat-placement-test/test11.rat"  "f" ("a",1)  (-1, "LB")
    
let%test "test12_f_b" = 
  test "../../fichiersRat/src-rat-placement-test/test12.rat"  "f" ("b",1)  (-3, "LB")
    
let%test "test12_f_r" = 
  test "../../fichiersRat/src-rat-placement-test/test12.rat"  "f" ("r",1)  (-2, "LB")
    
let%test "test12_f_i" = 
  test "../../fichiersRat/src-rat-placement-test/test12.rat"  "f" ("i",1)  (-1, "LB")

let%test "teststruct1_x" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct1.rat" "main" ("x",1)  (0, "SB")

let%test "teststruct1_y" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct1.rat" "main" ("y",1)  (1, "SB")

let%test "teststruct1_p" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct1.rat" "main" ("p",1)  (0, "SB")

    let%test "teststruct2_x_1" = 
       test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("x",1)  (0, "SB")
  
    let%test "teststruct2_y_1" = 
        test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("y",1)  (1, "SB")
     
    let%test "teststruct2_p1" = 
        test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("p1",1)  (0, "SB")

    let%test "teststruct2_x_2" = 
            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("x",2)  (2, "SB")
          
    let%test "teststruct2_y_2" = 
            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("y",2)  (3, "SB")
          
    let%test "teststruct2_p2" = 
            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("p2",1)  (2, "SB")

    let%test "teststruct2_dx_1" = 
                test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("dx",1)  (4, "SB")
              
            let%test "teststruct2_dy_1" = 
                test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("dy",1)  (5, "SB")
              
            let%test "teststruct2_v" = 
                test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("v",1)  (4, "SB")

            let%test "teststruct2_x_3" = 
                    test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("x",3)  (6, "SB")
                  
            let%test "teststruct2_y_3" = 
                    test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("y",3)  (7, "SB")
                  
            let%test "teststruct2_p1t" = 
                    test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("p1t",1)  (6, "SB")

            let%test "teststruct2_x_4" = 
                        test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("x",4)  (8, "SB")
                      
            let%test "teststruct2_y_4" = 
                        test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("y",4)  (9, "SB")
                      
            let%test "teststruct2_p2t" = 
                        test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "main" ("p2t",1)  (8, "SB")

            let%test "teststruct2_x_translate_1" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("x",1)  (-4, "LB")
                          
            let%test "teststruct2_y_translate_1" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("y",1)  (-3, "LB")
                          
            let%test "teststruct2_p_translate" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("p",1)  (-4, "LB")

            let%test "teststruct2_dx_translate_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("dx",1)  (-2, "LB")
                                          
                            let%test "teststruct2_dy_translate_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("dy",1)  (-1, "LB")
                                          
                            let%test "teststruct2_v_translate" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct2.rat" "translate" ("v",1)  (-2, "LB")


            let%test "teststruct3_a" = 
                        test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "main" ("a",1)  (0, "SB")

            let%test "teststruct3_z_1" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "main" ("z",1)  (0, "SB")
                          
            let%test "teststruct3_x_1" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "main" ("x",1)  (1, "SB")
                          
            let%test "teststruct3_y_1" = 
                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "main" ("y",1)  (2, "SB")

            let%test "teststruct3_r2z_r" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2z" ("r",1)  (-2, "LB")
                                          
            let%test "teststruct3_r2z_z_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2z" ("z",1)  (-3, "LB")
                                          
                            let%test "teststruct3_r2z_x_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2z" ("x",1)  (-2, "LB")
                                          
                            let%test "teststruct3_r2z_y_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2z" ("y",1)  (-1, "LB")
            let%test "teststruct3_r2x_r" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2x" ("rec",1)  (-3, "LB")
                                          
            let%test "teststruct3_r2x_z_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2x" ("z",1)  (-3, "LB")
                                          
                            let%test "teststruct3_r2x_x_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2x" ("x",1)  (-2, "LB")
                                          
                            let%test "teststruct3_r2x_y_1" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct3.rat" "r2x" ("y",1)  (-1, "LB")
  
  let%test "teststruct8_v3" = 
                                            test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("v3",1)  (0, "SB")
                      
  let%test "teststruct8_val_1" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("val",1)  (0, "SB")

  let%test "teststruct8_suivante_1" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("suivante",1)  (1, "SB")

  let%test "teststruct8_v2" = 
  test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("v2",1)  (2, "SB")

let%test "teststruct8_val_2" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("val",2)  (2, "SB")

let%test "teststruct8_suivante_2" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("suivante",2)  (3, "SB")


let%test "teststruct8_v1" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("v1",1)  (4, "SB")

let%test "teststruct8_val_3" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("val",3)  (4, "SB")

let%test "teststruct8_suivante_3" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("suivante",3)  (5, "SB")

let%test "teststruct8_inutil" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "main" ("inutil",1)  (6, "SB")


let%test "teststruct8_printListe_l" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("l",1)  (-2, "LB")

let%test "teststruct8_printListe_val_1" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("val",1)  (-2, "LB")

let%test "teststruct8_printListe_suivante_1" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("suivante",1)  (-1, "LB")



let%test "teststruct8_printListe_s" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("s",1)  (3, "LB")

let%test "teststruct8_printListe_val_2" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("val",2)  (3, "LB")

let%test "teststruct8_printListe_suivante_2" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("suivante",2)  (4, "LB")

let%test "teststruct8_printListe_inutil" = 
test "../../fichiersRat/src-rat-tam-test/teststruct8.rat" "printListe" ("inutil",1)  (5, "LB")
*)