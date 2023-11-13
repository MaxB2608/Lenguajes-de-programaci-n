#MAKEFILE JAVA

all: default run clean

JFLAGS = -g
JC = javac
JVM = java
MAIN = JavaQuest

.SUFFIXES: .java .class

.java.class: 
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	GraphGenerator.java \
	Edge.java \
	Item.java \
	Nodo.java \
	NodoCombate.java \
	NodoEvento.java \
	NodoInicial.java \
	NodoJefeFinal.java \
	NodoTienda.java \
	Personaje.java \
	Jugador.java \
	Mapa.java \
	Main.java \
	JavaQuest.java 


default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) 

clean: 
	$(RM) *.class
