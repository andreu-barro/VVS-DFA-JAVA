# VVS-DFA-JAVA
[![Build Status](https://travis-ci.org/andreu-barro/VVS-DFA-JAVA.svg?branch=master)](https://travis-ci.org/andreu-barro/VVS-DFA-JAVA)

Práctica para la asignatura de Validación y Verificación Software.

Integrantes:  
-Francisco Javier Moure López  
-Emma Oitaven Carracedo  
-Xoán Andreu Barro Torres  

La aplicación sobre la que haremos tests simplifica DFA (Autómatas Finitos Deterministas), eliminando transiciones redundantes y estados inalcanzables, para obtener un DFA equivalente (capaz de aceptar el mismo lenguaje).

Para ejecutar los reports: mvn test site. Los genera en target/site/Index.html, ahí navegamos a project reports.
Para ejecutar los reports de pitest: mvn test org.pitest:pitest-maven:mutationCoverage site

Esta aplicación fue programada en tres lenguajes distintos:

C: https://github.com/srjavimoure/VVS-DFA-C  
Java: Este repositorio  
Ocaml: PENDIENTE  
