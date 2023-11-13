#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include "certamen.h"

//Función que crea un certamen vacío
tCertamen* crearCertamen(int n_preguntas){

}

//Asigna la pregunta en la posición n_pregunta del certamen
void asignarPregunta(tCertamen* certamen, int n_pregunta, tPregunta* pregunta){
    certamen -> preguntas[n_pregunta-1] = *pregunta;
}

// Retorna el numero de preguntas en el certamen
int largoCertamen (tCertamen certamen){
    int largo_certamen = 0;
    largo_certamen = largo_certamen + certamen.n_preguntas;
    return largo_certamen;
};

//Retorna la pregunta en la posición n_pregunta del certamen
tPregunta leerPregunta(tCertamen* certamen, int n_pregunta){
    tPregunta lee = certamen -> preguntas[n_pregunta - 1];
    return lee;
}