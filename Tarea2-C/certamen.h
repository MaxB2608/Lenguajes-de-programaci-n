//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////                             /////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////          LIBRERÍAS          //////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////                             ///////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////                           /////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////          STRUCTS          //////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////                           ///////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Struct Alternativa 
typedef struct {
    char enunciado[128];
    int n_alternativas;
    char** alternativas;
    int alternativa_correcta;
} tEnunciadoAlternativa;

// Struct Alternativas Múltiples
typedef struct {
    char enunciado[128];
    int n_alternativas;
    char** alternativas;
    int n_correctas;
    int* alternativa_correcta;
} tEnunciadoAlternativaMultiple;

//Struct Verdadero o Falso
typedef struct{
    char enunciado[128];
    bool respuesta;
} tEnunciadoVerdaderoFalso;

// Struct del Enunciado a completar
typedef struct{
    int n_textos;
    char** textos;
    char** respuestas;
} tEnunciadoCompletar;

// Struct de la Pregunta
typedef struct{
    char tipo[64];
    void* enunciado;
    void* respuesta;
    bool (*fun)(void*);
} tPregunta;

// Struct del Certamen
typedef struct{
    int n_preguntas;
    tPregunta* preguntas;
} tCertamen;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////                             ///////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////          FUNCIONES          ////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////                             /////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Función que crea un certamen vacío

    Parametros :
        n_preguntas (int): cantidad de preguntas que debe tener el certamen

    Retorno :
        certamen (tCertamen*): retorna una variale tipo tCertamen inicializada con n_preguntas
*/

tCertamen* crearCertamen(int n_preguntas);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Crea una pregunta con el enunciado y funcion de revisión

    Parametros :
        certamen (tCertamen*): puntero que apunta al certamen  
        tipo (char*): puntero que aounta al tipo de pregunta creada
        enunciado (void*): puntero que apunta a la pregunta a responder
        revisar(void*,void*) (bool): función que se encarga de verificar si la respuesta es correcta

    Retorno :
        pregunta (tPregunta*): pregunta creada
*/

tPregunta* crearPregunta(tCertamen* certamen, char* tipo, void* enunciado, bool revisar(void*, void*));

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Asigna la pregunta en la posición n_pregunta del certamen

    Parametros :
        certamen (tCertamen*): puntero que apunta al certamen 
        n_pregunta (int): posición donde se asigna la pregunta
        pregunta (tPregunta): puntero que apunta a la pregunta a asignar

    Retorno :
        asigna (void): no se retorna nada, esta función es sólo para asignación
*/

void asignarPregunta(tCertamen* certamen, int n_pregunta, tPregunta* pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Retorna la pregunta en la posición n_pregunta del certamen 

    Parametros :
        certamen (tCertamen): puntero que apunta al certamen
        n_pregunta (int): posición de la pregunta a leer

    Retorno :
        lee (tPregunta): retorna la pregunta que se pidió leer en la posición n_pregunta
*/

tPregunta leerPregunta(tCertamen* certamen, int n_pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Retorna el numero de respuestas correctas que tiene el certamen

    Parametros :
        certamen (tCertamen): certamen donde se cuentan las respuestas correctas

    Retorno :
        buenas (int): retorna la cantidad de respuestas correctas 
*/

int nCorrectasCertamen(tCertamen certamen);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Retorna el numero de preguntas en un certamen

    Parametros :
        certamen (tCertamen): Struct certamen en el que se busca el largo del certamen 

    Retorno :
        largo_certamen (int): retorna el numero de preguntas
*/

int largoCertamen (tCertamen certamen);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Revisa si la respuesta a la pregunta tipo "AlternativaSimple" es correcta

    Parametros :
        pregunta (tPregunta): pregunta de tipo "AlternativaSimple" a revisar

    Retorno :
        revisar (bool): retorna si la respuesta es correcta o incorrecta
*/

bool revisarAlternativaSimple (tPregunta pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Revisa si la respuesta a la pregunta tipo "AlternativaMultiple" es correcta

    Parametros :
        pregunta (tPregunta): pregunta de tipo "AlternativaMultiple" a revisar

    Retorno :
        revisar (bool): retorna si la respuesta es correcta o incorrecta
*/

bool revisarAlternativaMultiple (tPregunta pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Revisa si la respuesta a la pregunta tipo "VerdaderoFalso" es correcta

    Parametros :
        pregunta (tPregunta): pregunta de tipo "VerdaderoFalso" a revisar

    Retorno :
        revisar (bool): retorna si la respuesta es correcta o incorrecta
*/

bool revisarVerdaderoFalso (tPregunta pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Revisa si la respuesta a la pregunta tipo "Completar" es correcta

    Parametros :
        pregunta (tPregunta): pregunta de tipo "Completar" a revisar

    Retorno :
        revisar (bool): retorna si la respuesta es correcta o incorrecta
*/

bool revisarCompletar (tPregunta pregunta);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////