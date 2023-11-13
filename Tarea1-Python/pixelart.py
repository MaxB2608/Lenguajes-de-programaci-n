import re 
import numpy as np
from PIL import Image
import os

################################################################################################################################################################################
'''
Permite buscar arrores de sintaxis en el archivo 

    Parametros:
        texto (.txt): Texto que se utilizará para encontrar dichos errores

    Retorno:
        nada, puesto que genera el archivo
'''

def errores (texto):
    s_l1 = r'^Ancho \d+$'
    s_l2 = r'^Color de fondo (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])$'
    s_l3 = r'\n'
    s_avanzar = r'\bAvanzar\s*\d*\b'
    s_pinta = (r'\bPintar (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])')
    s_left = (r'\bIzquierda\b')
    s_right = (r'\bDerecha\b')
    s_todo = r'(^Ancho \d+$|^Color de fondo (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])$|\bAvanzar\s*\d*\b|\bPintar (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])|\bIzquierda\b|\bDerecha\b)'
    txt = open(texto, 'r')
    errores = open('errores.txt', 'w')
    contador = 1
    for linea in txt:
        codigos_buenos = []
        fusion = ""
        c = re.findall(s_todo, linea)
        
        for ins in c:
            codigos_buenos.append(ins[0])
        for ins2 in codigos_buenos:
            fusion = fusion + " " + ins2
        fusion = fusion 
        fusion = fusion.replace("  ", " ")
        linea = " " + linea
        linea = linea.replace("\n", "")
        if linea == fusion:
            contador += 1
        if len(re.findall(r'\S+', linea)) == 0:
            contador += 1
        if linea != fusion and len(re.findall(r'\S+', linea)) > 0:
            errores.write(str(contador) + linea + "\n")
            contador += 1
    errores.close()
    txt.close()
################################################################################################################################################################################
'''
Permite retornar el valor de anchura que se pide de la matriz

    Parametros:
        texto (.txt): Texto que se utilizará para encontrar dicho valor

    Retorno:
        int(n[0]) (int): Valor de anchura transformado a int, puesto que en el txt es un string
'''

def ancho (texto):
    codigo = open(texto, 'r')
    lineas = codigo.readlines()
    codigo.close()
    n = re.findall(r'\d+',lineas[0])
    return int(n[0])
################################################################################################################################################################################
'''
Permite retornar una tupla que representa el color inicial de la matriz en formato RGB 

    Parametros:
        texto (.txt): Texto que se utilizará para encontrar dicha tupla o color

    Retorno:
        (0,0,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Negro' en la 2° línea del texto
        (255,0,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Rojo' en la 2° línea del texto
        (0,255,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Verde' en la 2° línea del texto
        (0,0,255) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Azul' en la 2° línea del texto
        (0,255,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Blanco' en la 2° línea del texto
        (int(c[0]),int(c[1]),int(c[2])) (tupla de int): Tupla que se retorna en caso de la existencia del string 'RGB\W+\d+\W+\d+\W+\d+\W+' en la 2° línea del texto
'''

def color0 (texto):
    codigo = open(texto, 'r')
    lineas = codigo.readlines()
    codigo.close()
    if re.search('Negro', lineas[1]) is not None:
        return (0,0,0)
    elif re.search('Rojo', lineas[1]) is not None:
        return (255,0,0)
    elif re.search('Verde', lineas[1]) is not None:
        return (0,255,0)
    elif re.search('Azul', lineas[1]) is not None:
        return (0,0,255)
    elif re.search('Blanco', lineas[1]) is not None:
        return (255,255,255)
    else:
        c = re.findall('\d+', lineas[1])
        return (int(c[0]),int(c[1]),int(c[2]))
################################################################################################################################################################################
'''
Permite retornar la matriz inicial con el tamaño y color entregado en el texto

    Parametros:
        texto (.txt): Texto que se utilizará para crear dicha matriz

    Retorno:
        matrix (lista de lista de tuplas de enteros): Matriz inicial hecha de listas de tuplas, las cuales representan el color inicial
'''

def matriz0 (texto):
    matrix = []
    y = 0
    while y < ancho(texto):
        fila = []
        x = 0
        while x < ancho(texto):
            fila.append(color0(texto))
            x += 1
        matrix.append(fila)
        y += 1    
    return matrix
################################################################################################################################################################################
'''
Permite retornar una lista con las instrucciones en orden

    Parametros:
        texto (.txt): Texto que se utilizará para buscar dichas instrucciones

    Retorno:
        instrucciones (lista): lista de strings con las instrucciones
'''

def instrucciones (texto):
    s_todo = r'(^Ancho \d+$|^Color de fondo (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])$|\bAvanzar\s*\d*\b|\bPintar (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])|\bIzquierda\b|\bDerecha\b)'
    text0 = open(texto,"r")
    instrucciones = []
    for x in text0:
        c = re.findall(s_todo, x)
        for k in c:
            instrucciones.append(k[0])
    text0.close()
    return instrucciones
################################################################################################################################################################################
'''
Permite retornar la orientación/dirección a la que se mueve

    Parametros:
        texto (.txt): Texto que se utilizará para buscar dicha orientación

    Retorno:
        pos_actual (string): orientación actualizada
'''
def girar_iz(dir):
    if dir == "derecha":
        pos_actual = "arriba"
        return pos_actual
    elif dir == "abajo":
        pos_actual = "derecha"
        return pos_actual
    elif dir == "izquierda":
        pos_actual = "abajo"
        return pos_actual
    elif dir == "arriba":
        pos_actual = "izquierda"
        return pos_actual
################################################################################################################################################################################
'''
Permite retornar la orientación/dirección a la que se mueve

    Parametros:
        texto (.txt): Texto que se utilizará para buscar dicha orientación

    Retorno:
        pos_actual (string): orientación actualizada
'''
def girar_der(dir):
    if dir == "derecha":
        pos_actual = "abajo"
        return pos_actual
    elif dir == "abajo":
        pos_actual = "izquierda"
        return pos_actual
    elif dir == "izquierda":
        pos_actual = "arriba"
        return pos_actual
    elif dir == "arriba":
        pos_actual = "derecha"
        return pos_actual
################################################################################################################################################################################
'''
Retorna la ubicación en la matriz después de avanzar x pasos

    Parametros:
        matriz (lista de lista de tuplas de enteros): matriz donde se avanzará
        instruccion (string): instrucción que dice cuanto hay que avanzar
        dir (string): orientación a donde se apunta (necesario para saber a donde ir)
        y (int): coordenada que representa la fila
        x (int): coordenada que representa la columna

    Retorno:
        ubicacion (tupla): ubicación en la matriz después de avanzar x pasos
'''

def avanzar(matriz0,instruccion, dir, y, x):
    anc = len(matriz0)
    n = re.findall(r'\d+',instruccion)
    if len(n) == 1:
        pasos = int(n[0])
    if len(n) == 0:
        pasos = 1
    
    if dir == "derecha":
        if x + pasos > anc:
            print("Los pasos se pasan de la matriz")
            exit()
        else:
            return (y, x + pasos)

    if dir == "izquierda":
        if x - pasos < 0:
            print("Los pasos se pasan de la matriz")
            exit()
        else:
            return (y, x - pasos)

    if dir == "arriba":
        if y - pasos < 0:
            print("Los pasos se pasan de la matriz")
            exit()
        else:
            return (y - pasos, x)

    if dir == "abajo":
        if y + pasos > anc:
            print("Los pasos se pasan de la matriz")
            exit()
        return (y + pasos, x)
################################################################################################################################################################################
'''
Intercambia la tupla en cuestion por otra que representa el color

    Parametros:
        instruccion (string): instrucción que dice cual es el color a pintar

    Retorno:
        (0,0,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Negro' en la 2° línea del texto
        (255,0,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Rojo' en la 2° línea del texto
        (0,255,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Verde' en la 2° línea del texto
        (0,0,255) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Azul' en la 2° línea del texto
        (0,255,0) (tupla de int): Tupla que se retorna en caso de la existencia del string 'Blanco' en la 2° línea del texto
        (int(c[0]),int(c[1]),int(c[2])) (tupla de int): Tupla que se retorna en caso de la existencia del string 'RGB\W+\d+\W+\d+\W+\d+\W+' en la 2° línea del texto
'''

def pintar(instruccion):
    if re.search('Negro', instruccion) is not None:
        colo = (0,0,0)
    
    elif re.search('Rojo', instruccion) is not None:
        colo = (255,0,0)
    
    elif re.search('Verde', instruccion) is not None:
        colo = (0,255,0)
    
    elif re.search('Azul', instruccion) is not None:
        colo = (0,0,255)
    
    elif re.search('Blanco', instruccion) is not None:
        colo = (255,255,255)
    
    else:
        c = re.findall('\d+', instruccion)
        colo = (int(c[0]),int(c[1]),int(c[2]))

    if colo[0] > 255 or colo[1] > 255 or colo[2] > 255:
        print("Color inexistente")
        exit()
    return colo
################################################################################################################################################################################
'''
Permite retornar la matriz final con los cambios realizados

    Parametros:
        texto (.txt): Texto que se utilizará para alterar dicha matriz

    Retorno:
        matriz (lista de lista de tuplas de enteros): Matriz final 
'''

def matriz_f (texto):
    matriz = matriz0(texto)

    z = 0

    x = 0
    y = 0

    p_actual = (y,x) 
    dir = "derecha"

    s_avanzar = r'\bAvanzar\s*\d*\b'
    s_pinta = (r'\bPintar (Azul|Verde|Rojo|Negro|Blanco|RGB[(]\d{1,3}[,]\d{1,3}[,]\d{1,3}[)])')
    s_left = (r'\bIzquierda\b')
    s_right = (r'\bDerecha\b')

    ins = instrucciones(texto)

    while z < len(ins):
        if re.search(s_avanzar, ins[z]) is not None:
            ins1 = avanzar(matriz, ins[z], dir, y, x)
            y = ins1[0]
            x = ins1[1]
            p_actual = (y,x)
            z += 1

        elif re.search(s_pinta, ins[z]) is not None:
            color = pintar(ins[z])
            matriz[p_actual[0]][p_actual[1]] = color
            z += 1

        elif re.search(s_left, ins[z]) is not None:
            ins3 = girar_iz(dir)
            dir = ins3
            z += 1

        elif re.search(s_right, ins[z]) is not None:
            ins4 = girar_der(dir)
            dir = ins4
            z += 1
        else:
            z += 1
    return matriz
################################################################################################################################################################################
def MatrizAImagen(matriz, filename='pixelart.png', factor=10):
    '''
    Convierte una matriz de valores RGB en una imagen y la guarda como un archivo png.
    Las imagenes son escaladas por un factor ya que con los ejemplos se producirian imagenes muy pequeñas.
        Parametros:
                matriz (lista de lista de tuplas de enteros): Matriz que representa la imagen en rgb.
                filename (str): Nombre del archivo en que se guardara la imagen.
                factor (int): Factor por el cual se escala el tamaño de las imagenes.
    '''
    matriz = np.array(matriz, dtype=np.uint8)
    np.swapaxes(matriz, 0, -1)
    N = np.shape(matriz)[0]
    img = Image.fromarray(matriz, 'RGB')
    img = img.resize((N*10, N*10), Image.Resampling.BOX)
    img.save(filename)
################################################################################################################################################################################

#main que comprueba si hay errores de sintaxis, en caso de no haberlos genera la imagen
print (errores("codigo.txt"))
error = open('errores.txt', 'a')
if os.stat('errores.txt').st_size == 0:
    error.write("No hay errores!")
    error.close()
    print(MatrizAImagen(matriz_f('codigo.txt')))