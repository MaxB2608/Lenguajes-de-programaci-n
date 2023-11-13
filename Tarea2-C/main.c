#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include "certamen.h"
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#define L_MAXIMO_CADENA 129     // Se define el máximo de carácteres, el cual está en los structs + 1
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int main(){                                             
    FILE *fp;                               
    fp = fopen("certamen.txt", "r");
    if (fp == NULL){
        printf("ERROR - Archivo no encontrado");
        exit(1);
    }                                                       ////////////////////////////////////////////////////////////////////////////////////////////////////
    char linea[L_MAXIMO_CADENA];                            ////    En esta parte se lee el archivo y se almacenan las líneas en un arreglo de un tamaño    ////
    int contador = 0;                                       ////    equivalente a la cantidad de líneas.                                                    ////
    while (fgets(linea, L_MAXIMO_CADENA, fp)){              ////////////////////////////////////////////////////////////////////////////////////////////////////
        strtok(linea, "\n");
        contador++;
    }
    rewind(fp);
    int k = 0;
    char certamen_array [contador] [129];
    while (fgets(linea, L_MAXIMO_CADENA, fp)){
        strtok(linea, "\n");
        strcpy(certamen_array[k], linea);
        k++;
    }
    fclose(fp);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int cantidad_preguntas = atoi(certamen_array[0]);
    int nota = 0;
    char as[18] = "AlternativaSimple";
    char am[20] = "AlternativaMultiple";
    char vf[15] = "VerdareroFalso";
    char c [10] = "Completar";

    for(int x = 0; x < contador; x++){
        //////////////////////////////////////////////////////////////////////////////////////////
        if (strcmp(certamen_array[x], as) == 0){                                                //
            ////////////////////////////////////////////////////////////////////                //
            char pregunta[128];                                                                 //
            strcpy(pregunta,certamen_array[x+1]);                                               //    
            ////////////////////////////////////////////////////////////////////                //
            int cantidad = atoi(certamen_array[x+2]);                                           //
            ////////////////////////////////////////////////////////////////////                //
            char alternativas [cantidad][129];                                                  //
            for(int z = 0; z < cantidad;z++){                                                   //
                strcpy(alternativas[z], certamen_array[x+3+z]);                                 //    
            }                                                                                   //
            ////////////////////////////////////////////////////////////////////                //
            char respuesta[129];                                                                //
            strcpy(respuesta,certamen_array[x+3+cantidad]);                                     //
            ////////////////////////////////////////////////////////////////////                //
            char usuario[129];                                                                  //
            ////////////////////////////////////////////////////////////////////                //
                                                                                                //  Sección en caso
            printf("Tipo de pregunta: Alternativa Simple\n");                                   //  de que la pregunta
            printf("\n");                                                                       //  sea una alternativa
            printf("Pregunta: %s\n", pregunta);                                                 //
            printf("\n");                                                                       //
            printf("Tiene %d alternativas:\n", cantidad);                                       //
            printf("\n");                                                                       //
            for (int k = 0; k < cantidad; k++){                                                 //
                printf("%s\n", alternativas[k]);                                                //
            }                                                                                   //
            printf("\n");                                                                       //
            printf("Seleccione UNA alternativa por el orden de aparacición.\n");                //
            printf("Es decir, que si para usted la primera alternativa es la correcta, responda 1.\n");
            printf("Ingrese su respuesta: ");                                                   //
            scanf("%s", usuario);                                                               //
            printf("\n");                                                                       //
            if (strcmp(usuario,respuesta) == 0){                                                //
                nota++;                                                                         //
            }                                                                                   //
            printf("\n");                                                                       //
        }                                                                                       //
        //////////////////////////////////////////////////////////////////////////////////////////


        
        //////////////////////////////////////////////////////////////////////////////////////////
        if (strcmp(certamen_array[x], am) == 0){                                                //
            ////////////////////////////////////////////////////////////////////                //
            char pregunta[128];                                                                 //
            strcpy(pregunta,certamen_array[x+1]);                                               //
            ////////////////////////////////////////////////////////////////////                //
            int cantidad = atoi(certamen_array[x+2]);                                           //
            ////////////////////////////////////////////////////////////////////                //
            char alternativas [cantidad][129];                                                  //
            for(int z = 0; z < cantidad;z++){                                                   //
                strcpy(alternativas[z], certamen_array[x+3+z]);                                 //    
            }                                                                                   //
            ////////////////////////////////////////////////////////////////////                //
            int correctas;                                                                      //
            correctas = atoi(certamen_array[x+3+cantidad]);                                     //
            ////////////////////////////////////////////////////////////////////                //
            char respuestas [correctas][128];                                                   //
            for(int z = 0; z < correctas;z++){                                                  //
                strcpy(respuestas[z], certamen_array[x+4+cantidad+z]);                          //    
            }                                                                                   //
            ////////////////////////////////////////////////////////////////////                //
            int correct;                                                                        //
            correct = 0;                                                                        //
            char usuario [correctas][129];                                                      //
            ////////////////////////////////////////////////////////////////////                //
            printf("Tipo de pregunta: Alternativa Multiple\n");                                 //  Sección en caso
            printf("\n");                                                                       //  de que la pregunta
            printf("Pregunta: %s\n", pregunta);                                                 //  sea una alternativa
            printf("\n");                                                                       //  múltiple
            printf("Tiene %d alternativas:\n", cantidad);                                       //
            printf("\n");                                                                       //
            for (int k = 0; k < cantidad; k++){                                                 //
                printf("%s\n", alternativas[k]);                                                //
            }                                                                                   //
            printf("\n");                                                                       //
            printf("Seleccione las alternativas que considere correctas en orden creciente.\n");//
            printf("Es decir, que si para usted la primera y tercera alternativa son las correctas, responda 1 y luego responda 3.\n");
            printf("\n");                                                                       //
            printf("SPOILER: Son %d alternativas correctas.\n", correctas);                     //
            printf("\n");                                                                       //
            for (int x = 0; x < correctas; x++){                                                //
                printf("Escriba su respuesta: ");                                               //
                scanf("%s", usuario[x]);                                                        //
                printf("\n");                                                                   //
                if ((strcmp(usuario[x],respuestas[x]) == 0)){                                   //
                    correct++;                                                                  //
                }                                                                               //
            if (correct == correctas){                                                          //
                nota++;                                                                         //
            }                                                                                   //
            }                                                                                   //
        }                                                                                       //
        //////////////////////////////////////////////////////////////////////////////////////////



        //////////////////////////////////////////////////////////////////////////////////////////
        if (strcmp(certamen_array[x], vf) == 0){                                                //
            ////////////////////////////////////////////////////////////////////                //
            bool res;                                                                           //
            if (strcmp(certamen_array[x+2], "V") == 0){                                         //
                res = true;                                                                     //
            }                                                                                   //
            if (strcmp(certamen_array[x+2], "F") == 0){                                         //
                res = false;                                                                    //
            }                                                                                   //  Sección en caso
            ////////////////////////////////////////////////////////////////////                //  de que la pregunta
            char pregunta[129];                                                                 //  sea de verdadero o
            strcpy(pregunta, certamen_array[x+1]);                                              //  falso
            char r_correcta[129];                                                               //  
            strcpy(r_correcta, certamen_array[x+2]);                                            //
            ////////////////////////////////////////////////////////////////////                //
            char usuario[129];                                                                  //
            int conversion;                                                                     //
            ////////////////////////////////////////////////////////////////////                //
            printf("Tipo de pregunta: Verdadero o Falso\n");                                    //
            printf("\n");                                                                       // 
            printf("Pregunta: %s\n", pregunta);                                                 //
            printf("\n");                                                                       //
            printf("Responda V si cree que es verdadero o F si cree que es falso.\n");          //
            printf("\n");                                                                       //
            printf("Ingrese su respuesta: ");                                                   //
            scanf("%s", usuario);                                                               //
            printf("\n");                                                                       //
            if (strcmp(usuario, r_correcta) == 0){                                              //
                nota++;                                                                         //
            }                                                                                   //
            printf("\n");                                                                       //
        }                                                                                       //
        //////////////////////////////////////////////////////////////////////////////////////////



        //////////////////////////////////////////////////////////////////////////////////////////
        if (strcmp(certamen_array[x], c) == 0){                                                 //
            ////////////////////////////////////////////////////////////////////                //                
            int cantidad_textos;                                                                //
            cantidad_textos = atoi (certamen_array[x+1]);                                       //
            ////////////////////////////////////////////////////////////////////                //
            int cantidad_respuestas;                                                            //
            cantidad_respuestas = cantidad_textos - 1;                                          //
            ////////////////////////////////////////////////////////////////////                //
            char frases [cantidad_textos][129];                                                 //
            for(int z = 0; z < cantidad_textos;z++){                                            //
                strcpy(frases[z], certamen_array[x+2+z]);                                       //    
            }                                                                                   //
            ////////////////////////////////////////////////////////////////////                //
            char palabras [cantidad_respuestas][129];                                           //
            for(int z = 0; z < cantidad_respuestas; z++){                                       //
                strcpy(palabras[z], certamen_array[x+2+z+cantidad_textos]);                     //    
            }                                                                                   //  Sección en caso
            ////////////////////////////////////////////////////////////////////                //  de que la pregunta
            int buenas;                                                                         //  sea de Completar
            buenas = 0;                                                                         //
            char usuario [cantidad_respuestas][129];                                            //
            ////////////////////////////////////////////////////////////////////                //
            printf("Tipo de pregunta: Completar\n");                                            //
            printf("\n");                                                                       //
            printf("A continuación se le presentarán %d frases, las cuales tiene que enlazar a través de una frase/palabra que hay entre ellas.\n",cantidad_textos);
            printf("\n");                                                                       //
            printf("Por ejemplo:\n");                                                           //
            printf("La universidad Técnica Santa María tiene\n");                               //
            printf("muy odiados, el más odiado por la comunidad en general es el\n");           //
            printf(", que será recordado por muchos de mala forma.\n");                         //
            printf("\n");                                                                       //
            printf("Aquí la frases/palabras para completar la frase son 'departamentos' y 'DFIS', dejando la frase completa:\n");
            printf("La universidad Técnica Santa María tiene departamentos muy odiados, el más odiado por la comunidad en general es el DFIS, que será recordado por muchos de mala forma. \n");
            printf("\n");                                                                       //
            printf("Ahora le toca a usted:\n");                                                 //
            printf("\n");                                                                       //
            for (int k = 0; k < cantidad_textos; k++){                                          //
                printf("%s\n", frases[k]);                                                      //
            }                                                                                   //
            printf("\n");                                                                       //
            printf("Respuestas:\n");                                                            //
            for (int x = 0; x < cantidad_respuestas; x++){                                      //
                scanf("%s", usuario[x]);                                                        //
                printf("\n");                                                                   //
                if ((strcmp(usuario[x],palabras[x]) == 0)){                                     //
                    buenas++;                                                                   //
                }                                                                               //
            if (buenas == cantidad_respuestas){                                                 //
                nota++;                                                                         //
            }                                                                                   //
            }                                                                                   //
        }                                                                                       //
        //////////////////////////////////////////////////////////////////////////////////////////
    }
    printf("\n");
    if (100*nota >= cantidad_preguntas*55){
        printf("¡FELICIDADES!, pasaste con %d/%d", nota, cantidad_preguntas);
        printf("\n");
    }
    if (100*nota < cantidad_preguntas*55){
        printf("¡QUE MAL!, reprobaste con %d/%d", nota, cantidad_preguntas);
        printf("\n");
    }
    return 0;
}