Nombre: Maximiliano Alberto Bardi Ureta
ROl: 202173510-0
Rut: 21.030.899-7

El código fue realizado con DrRacket, específicamente la versión 8.6, es el mismo que está en el link de la tarea.

Realicé casos de prueba que funcionan, aquí van:

*CASOS ENTREGADOS POR EL PDF*

(inverso '(1 3 7) 10)
(umbral_simple '(15 2 1 3 27 5 10) 5 #\M)
(umbral_cola '(15 2 1 3 27 5 10) 5 #\M)
(umbral_simple '(15 2 1 3 27 5 10) 5 #\m)
(umbral_cola '(15 2 1 3 27 5 10) 5 #\m)
(modsel_simple '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
(modsel_cola '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
(modsel_simple '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))
(modsel_cola '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))
(estables '(15 2 1 3 27 5 10) 5 (lambda (x) (/ x 2)) (lambda (x) (* x 2)))
(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 1 1 '(1 #\M))
(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 0 2 '((0 4) (lambda(x) (+ x 100))))
(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 2 3 '(5 (lambda (x)(/ x 2)) (lambda (x) (* x 2))))

*CASOS PARA INVERSO*

(inverso '(0 7 9 10 13 17 18) 20)
(inverso '(1 4 2) 5)
(inverso '(1 4 2 7) 8)

*CASOS PARA UMBRAL SIMPLE/COLA*

(umbral_simple '(8 5 1 3) 6 #\m)
(umbral_cola '(8 5 1 3) 6 #\m)
(umbral_simple '(1 5 9 3 57 25 10 7 55 80) 10 #\M)
(umbral_cola '(1 5 9 3 57 25 10 7 55 80) 10 #\M)
(umbral_simple '(0 34 88 25 26 24 17 40 11 5) 25 #\m)
(umbral_cola '(0 34 88 25 26 24 17 40 11 5) 25 #\m)

*CASOS PARA MODSEL SIMPLE/COLA*

(modsel_simple '(0 0 0 10 10 10) '(1 2 5) (lambda (x) (+ x 10)))
(modsel_cola '(0 0 0 10 10 10) '(1 2 5) (lambda (x) (+ x 10)))
(modsel_simple '(0 20 0 30 0 40) '(1 3 5) (lambda (x) (/ x 2)))
(modsel_cola '(0 20 0 30 0 40) '(1 3 5) (lambda (x) (/ x 2)))
(modsel_simple '(0 20 0 30 0 40) '(1 3 5) (lambda (x) (* x 2)))
(modsel_cola '(0 20 0 30 0 40) '(1 3 5) (lambda (x) (* x 2)))

*CASOS ESTABLES*
(estables '(15 2 10 3 17 8 11) 5 (lambda (x) (+ x 5)) (lambda (x) (* x 2)))
(estables '(100 300 600 40 10) 50 (lambda (x) (/ x 5)) (lambda (x) (* x 2)))
(estables '(10 14 0 8) 2 (lambda (x) (/ x 2)) (lambda (x) (* x 10)))

*CASOS QUERY*
(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 2 1 '(3 #\M))
(query '((0 1 2 3 4 5) (4 3 2 1 0) (15 2 1 3 27 5 10)) 0 2 '((0 4) (lambda(x) (+ x 50))))
(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 1 3 '(2 (lambda (x)(+ x 2)) (lambda (x) (* x 2))))