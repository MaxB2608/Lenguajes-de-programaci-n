% sepparimpar(L, P, I): Funcion donde L es una lista, P la lista con los elementos en las posiciones pares de L, e I es la lista con los elementos en las posiciones impares de L
sepparimpar([], [], []).
sepparimpar([C],[C],[]).
sepparimpar([C,X|T],[C|T1],[X|X1]):- sepparimpar(T, T1, X1).



% sublista(L1,L2): Función que comprueba que L1 es sublista de L2
sublista(L1,L2):- append(_L3,L4,L2), append(L1,_L5,L4).

% ultimo(X,L): Funcion que retorna el ultimo elemento de una lista
ultimo(X,L):- append(_,[X],L).

% primero(L,X): Funcion que retorna el primer elemento de una lista L
primero([X|_],X).


% todosrango(L, Min, Max): Funcion tal que L sea una lista que contenga todos los numeros enteros en el intervalo
todosrango([], C, C).
todosrango([C], C, K):- K is C+1.
todosrango(L, X, Y):- sort(L,Z), sublista(W, Z), primero(W, X), ultimo(K,W), Y is K+1, length(W, Q), Q is Y-X, member(X, L), member(K,L).



% rangomax(L, Min, Max): Funcion tal que L sea una lista y el intervalo es el mas grande posible.
rangomax(L, Min, Max):- sort(L,Z), ultimo(K, Z), primero(Z, Min), Max is K+1,  length(Z, Q), Q is Max-Min.