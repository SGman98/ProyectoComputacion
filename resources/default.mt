.mt
#alphabet
a
b
c

#states
q0
q1
q2
q3
q4
q5

#initial
q0

#accepting
q5

#transitions
q0:Y~q4:Y:>
q1:Y~q1:Y:>
q0:a~q1:X:>
q0:!~q5:!:-
q1:a~q1:a:>
q3:X~q0:X:>
q2:Z~q2:Z:>
q3:Y~q3:Y:<
q3:Z~q3:Z:<
q4:Y~q4:Y:>
q4:Z~q4:Z:>
q1:b~q2:Y:>
q2:b~q2:b:>
q3:a~q3:a:<
q2:c~q3:Z:<
q3:b~q3:b:<
q4:!~q5:!:-
