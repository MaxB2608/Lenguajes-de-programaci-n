#lang scheme (current-namespace (make-base-namespace))

;; Nota: las funciones entre ";;;;;;;;" son las pedidas en la tarea, el resto son funciones extra

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Funcion que entrega una lista de numeros del 0 al n (sin incluirlo) que no estan en una lista dada como parametro
;;
;; lista: Lista de los numeros que no debe incluir la funcion
;; n: Numero que determina el maximo de numeros a entregar en la lista, si este es 10 por ejemplo, se debe entregar una lista de 0 a 9 (sin considerar el parametro anterior)

(define (inverso lista n)
  (reverse (chao lista (lista_nueva n))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Funcion que entrega una lista de numeros del 0 al n (sin incluirlo)
;;
;; n: Numero que determina el maximo de numeros a entregar en la lista

(define (lista_nueva n)
  (if (= n 0)
      '()
      (cons (- n 1) (lista_nueva (- n 1)))))

;; Funcion que elimina los elementos comunes entre 2 listas
;;
;; l1: lista 1 a comparar
;; l2: lista 2 a comparar

(define (chao l1 l2)
  (if (empty?(comunes l1 l2))
      l2
      (chao l1 (elimina l2 (car (comunes l1 l2))))))

;; Funcion que elimina un numero x de una lista
;;
;; lista: lista donde se encuentra el elemento a eliminar
;; x: numero a eliminar

(define elimina (lambda (lista x)
                  (if (null? lista)
                      '()
                      (if (= (car lista) x)
                          (elimina (cdr lista) x)
                          (cons (car lista) (elimina (cdr lista) x))))))

;; Funcion que retorna una lista con los numeros que tienen en comun 2 listas
;;
;; l1: lista 1 a comparar
;; l2: lista 2 a comparar

(define comunes (lambda (l1 l2)
                  (if (null? l1)
                      '()
                      (if (null? (busca (car l1) l2))
                          (comunes (cdr l1) l2)
                          (cons (car l1) (comunes (cdr l1) (cdr l2)))))))

;; Funcion que busca un numero x en la lista
;;
;; x: numero a buscar
;; lista: lista donde se encuentra dicho numero

(define busca (lambda (x lista)
                (if (null? lista)
                    '()
                    (if (= (car lista) x)
                        (cons x (busca x (cdr lista)))
                        (busca x (cdr lista))))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Funcion que retorna una lista con las posiciones de los elementos de una lista que son mayores o menores respecto a un numero entregado (version simple)
;;
;; lista: lista donde se analiza cuales son mayores o menores respecto al numero entregado
;; umbral: numero entregado, dependiendo de lo que se pide, habrá que entregar la ubicacion de los numeros mayores o menores a este
;; tipo: define si lo que se busca son las ubicaciones de los numeros mayores o menores al umbral

(define (umbral_simple lista umbral tipo)
  (let nueva_l((lis lista) (contador 0))
    (if (empty? lis)
        '()
        (if (equal? tipo #\M)
            (if (> (car lis) umbral)
                (cons contador (nueva_l (cdr lis) (+ contador 1)))
                (nueva_l (cdr lis) (+ contador 1)))
            (if (< (car lis) umbral)
                (cons contador (nueva_l (cdr lis) (+ contador 1)))
                (nueva_l (cdr lis) (+ contador 1)))))))
                                
;; Funcion que retorna una lista con las posiciones de los elementos de una lista que son mayores o menores respecto a un numero entregado (version cola)
;;
;; lista: lista donde se analiza cuales son mayores o menores respecto al numero entregado
;; umbral: numero entregado, dependiendo de lo que se pide, habrá que entregar la ubicacion de los numeros mayores o menores a este
;; tipo: define si lo que se busca son las ubicaciones de los numeros mayores o menores al umbral

(define (umbral_cola lista umbral tipo)
  (let nueva_l((l '()) (lis lista) (contador 0))
    (if (equal? tipo #\M)
        (if(empty? lis)
           (reverse l)
           (if(> (car lis) umbral)
              (nueva_l (cons contador l) (cdr lis) (+ contador 1))
              (nueva_l l (cdr lis) (+ contador 1))))
        (if(empty? lis)
           (reverse l)
           (if(< (car lis) umbral)
              (nueva_l (cons contador l) (cdr lis) (+ contador 1))
              (nueva_l l (cdr lis) (+ contador 1)))))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Funcion que ordena una lista en orden creciente
;;
;; lista: lista a ordenar

(define (ordenar lista)
  (cond
    ((empty? lista) empty)
    (else(cons(menor lista) (ordenar(elimina lista (menor lista)))))))

;; Funcion que retorna el menor numero de la lista
;;
;; lista: lista donde se busca el menor numero
(define (menor lista)
  (cond
    ((empty? lista) empty)
    ((empty? (cdr lista)) (car lista))
    ((< (car lista) (car(cdr lista))) (menor (cons (car lista) (cddr lista))))
    (else (menor (cdr lista)))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Funcion que aplica una funcion f a unos elementos de una lista, determinados por otra lista con los indices de los numeros, a los cuales se les aplica la funcion (version simple)
;;
;; lista: lista con los elementos donde se evaluara si se aplica la funcion o no
;; seleccion: lista con los indices de los numeros a aplicar la funcion
;; f: funcion que se aplicará en algunos numeros

(define (modsel_simple lista seleccion f)
  (let n_mod ((lis lista) (lis2 (ordenar seleccion)) (funcion f) (contador 0))
    (if (empty? lis)
        '()
        (if (empty? lis2)
            (cons (car lis) (n_mod (cdr lis) lis2 funcion (+ contador 1)))
            (if (equal? contador (car lis2))
                (cons (funcion (car lis)) (n_mod (cdr lis) (cdr lis2) funcion (+ contador 1)))
                (cons (car lis) (n_mod (cdr lis) lis2 funcion (+ contador 1))))))))
                        
                        
            

;; Funcion que aplica una funcion f a unos elementos de una lista, determinados por otra lista con los indices de los numeros, a los cuales se les aplica la funcion (version cola)
;;
;; lista: lista con los elementos donde se evaluara si se aplica la funcion o no
;; seleccion: lista con los indices de los numeros a aplicar la funcion
;; f: funcion que se aplicará en algunos numeros
            
(define (modsel_cola lista seleccion f)
  (let n_mod (( lis_f '()) (lis lista) (lis2 (ordenar seleccion)) (funcion f) (contador 0))
    (if (empty? lis)
        (reverse lis_f)
        (if (empty? lis2)
            (n_mod (cons (car lis) lis_f) (cdr lis) lis2 funcion (+ contador 1))
            (if (equal? contador (car lis2))
                (n_mod (cons (funcion (car lis)) lis_f) (cdr lis) (cdr lis2) funcion (+ contador 1))
                (n_mod (cons (car lis) lis_f) (cdr lis) lis2 funcion (+ contador 1)))))))

;; Funcion que retorna una lista, en donde el primer numero es la cantidad de numeros mayores que un numero arbitrario que al aplicarles una funcion, siguen siendo mayores que el numero, y el
;; segundo es la cantidad de numeros menores que el numero arbitrario que al aplicarles una funcion siguen siendo menores que el numero.
;;
;; lista: lista con los numeros a evaluar
;; umbral: numero entregado, donde hay que evaluar los numeros mayores o menores a este
;; fM: funcion que se aplica a los numeros mayores al umbral
;; fm: funcion que se aplica a los numeros menores al umbral

(define (estables lista umbral fM fm)
  (let estable ((lis_f '()) (lis lista) (funcion1 fM) (funcion2 fm))
    (if (empty? lis)
        '()
        (list (length (umbral_cola (modsel_cola lis (umbral_cola lis umbral #\M) fM) umbral #\M)) (length (umbral_cola (modsel_cola lis (umbral_cola lis umbral #\m) fm) umbral #\m))))))

;; Funcion que retorna el resultado de una operacion realizada en una de las listas que se nos entrega
;;
;; lista: lista de listas, donde se aplicará la operacion a una de ellas 
;; pos: indice/posicion donde se encuentra la lista a la que se le aplica la operacion
;; op: indica cual es la operacion a realizar, este puede ser 1, 2 o 3
;; params: lista con los parametros necesarios para realizar la operacion

(define (query lista pos op params)
  (let k ((lis lista) (para params) (contador 0))
    (if (empty? lis)
        '()
        (if (equal? contador pos)
            (cond
              ((equal? op 1) (umbral_cola (car lis) (car para) (cadr para)))
              ((equal? op 2) (modsel_cola (car lis) (car para) (eval (cadr para))))
              (else (estables (car lis)(car para) (eval (cadr para)) (eval (caddr para)))))
            (k (cdr lis) para (+ contador 1))))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;