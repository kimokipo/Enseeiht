function [mu,Sigma] = estimation_mu_Sigma(X);
mu = mean(mean(X));
n = length(X);
X_centre = X - mu;
Sigma = transpose(X_centre)*X_centre/n;
end
