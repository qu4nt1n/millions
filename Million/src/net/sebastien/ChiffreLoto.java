package net.sebastien;

import java.util.Random;

public class ChiffreLoto{


int[] resultat = new int [5];
int[] etoiles = new int[2];
String tirage = "";

public String tirage(){
Random alea= new Random();
for(int i = 0; i<5; i++)
resultat[i]=alea.nextInt(50)+1;
for (int i = 0; i<2; i++)
etoiles[i] = alea.nextInt(11)+1;
for (int i =0; i<5;i++)
tirage +=resultat[i]+ "\n";
tirage +="étoiles\t"; 
for (int i=0; i<2; i++)
tirage += etoiles[i]+ "\t";
return tirage;
}}