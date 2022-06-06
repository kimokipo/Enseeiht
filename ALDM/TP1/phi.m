function [P] = phi(I,I_bar,Q)
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
P = (I-I_bar)'*Q*(I-I_bar);
end