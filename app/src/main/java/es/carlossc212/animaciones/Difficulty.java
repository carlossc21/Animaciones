package es.carlossc212.animaciones;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;

public class Difficulty {

    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;

    private static String pregunta;
    private static int respuesta;


    private static ArrayList<Pelota> pelotas;
    private static Random r = new Random();


    public static ArrayList<Pelota> easy(){

        pelotas = new ArrayList<>();

        int[][] dir = {{1,1}, {2,1}, {1,2}, {1,3}};
        int[] velocidades = {20, 10, 10, 10};
        int pelota = 0;

        int n = 4;

        int rojas = r.nextInt(n-2)+1;
        System.out.println(rojas + "rojas");
        int verdes = n-rojas;
        System.out.println(verdes + "verdes");

        for (int i = 0; i < rojas; i++) {
            Pelota p = new Pelota(500,500,100, Color.RED);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < verdes; i++) {
            Pelota p = new Pelota(500,500,100, Color.GREEN);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }


        String[] preguntas = {"¿Cuantas pelotas rojas hay?", "¿Cuantas pelotas verdes hay?"};
        int[] respuestas = {rojas, verdes};

        int g = r.nextInt(2);
        pregunta = preguntas[g];
        respuesta = respuestas[g];

        return pelotas;
    }


    public static ArrayList<Pelota> medium(){
        pelotas = new ArrayList<>();

        int[][] dir = {{1,1}, {2,1}, {1,2}, {1,3}, {3,1}, {2,3}};
        int[] velocidades = {20, 20, 20, 20, 20, 30};
        int pelota = 0;

        int n = 6;

        int rojas = r.nextInt(n-3)+1;
        int verdes = r.nextInt(n-rojas)+1;
        if ((rojas+verdes)>= n){
            verdes--;
        }
        int azules = n - (rojas+verdes);

        for (int i = 0; i < rojas; i++) {
            Pelota p = new Pelota(500,500,100, Color.RED);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < verdes; i++) {
            Pelota p = new Pelota(500,500,100, Color.GREEN);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < azules; i++) {
            Pelota p = new Pelota(500,500,100, Color.BLUE);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        String[] preguntas = {"¿Cuantas pelotas rojas hay?", "¿Cuantas pelotas verdes hay?", "¿Cuantas pelotas azules hay?"};
        int[] respuestas = {rojas, verdes, azules};

        int g = r.nextInt(3);
        pregunta = preguntas[g];
        respuesta = respuestas[g];


        return pelotas;
    }


    public static ArrayList<Pelota> hard(){
        pelotas = new ArrayList<>();



        int[][] dir = {{1,1}, {2,1}, {1,2}, {1,3}, {3,1}, {2,3}, {3,2}, {3,4},{1,4},{4,2}};
        int[] velocidades = {20, 20, 20, 20, 20, 30, 20, 20, 20,20};
        int pelota = 0;

        int n = 10;

        int rojas = r.nextInt(n-7)+1;
        int verdes = r.nextInt(n-7)+1;
        int azules = r.nextInt(n-7)+1;
        int amarillas = n-(rojas+verdes+azules);



        for (int i = 0; i < rojas; i++) {
            Pelota p = new Pelota(500,500,100, Color.RED);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < verdes; i++) {
            Pelota p = new Pelota(500,500,100, Color.GREEN);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < azules; i++) {
            Pelota p = new Pelota(500,500,100, Color.BLUE);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }

        for (int i = 0; i < amarillas; i++) {
            Pelota p = new Pelota(500,500,100, Color.YELLOW);
            p.direction = dir[pelota];
            p.speed = velocidades[pelota];
            pelota++;
            pelotas.add(p);
        }


        String[] preguntas = {"¿Cuantas pelotas rojas hay?", "¿Cuantas pelotas verdes hay", "¿Cuantas pelotas azules hay?", "¿Cuantas pelotas amarillas hay?"};
        int[] respuestas = {rojas, verdes, azules, amarillas};

        int g = r.nextInt(4);
        pregunta = preguntas[g];
        respuesta = respuestas[g];


        return pelotas;
    }

    public static String generaPregunta(){

        return pregunta;
    }

    public static int getRespuesta(){

        return respuesta;
    }
}
