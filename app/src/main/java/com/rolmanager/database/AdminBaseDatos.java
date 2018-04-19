package com.rolmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminBaseDatos extends SQLiteOpenHelper {

    public AdminBaseDatos (Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table tableEspecies(nombre text PRIMARY KEY,\n" +
                "        edadMedia INTEGER,\n" +
                "        edadAdulta INTEGER,\n" +
                "        pesoMinimo INTEGER,\n" +
                "        pesoMaximo INTEGER,\n" +
                "        alturaMinima FLOAT,\n" +
                "        alturaMaxima FLOAT,\n" +
                "        aspectos text,\n" +
                "        relacionOtrasEspecies text,\n" +
                "        imagen text)");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Elfos',280,40,35,90,1.20,2.30,'Hermoso (+1 Carisma), Agil (+1 Destreza), Vision fina (+5 a las pruebas de otear), Vision en la oscuridad casi absoluta, Enclenque (-1 Constitucion)','No son amigos de relacionarse con otras especies, aunque les agrada la compañia de gnomos y medianos. A los humanos los respetan, pero prefieren mantenerse distantes hasta que los conocen. Suelen ser hostiles con los enanos, desprecian a los trasgos y odian a los orcos','res/mipmap/elfo.png');\n" +
                "    ");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Enanos',200,30,80,120,1.10,1.60,'Robusto (+1 Constitución), Antipático (-1 Carisma), Subterráneo (visión en la infraoscuridad, +5 a orientarse bajo la superficie), Resistente a la magia (+2 a todas las TS contra efectos mágicos)','No suelen gustar de otras especies como compañeros, sin embargo, si tienen que elegir prefieren a humanos. Gnomos y medianos, cuando consiguen ganarse el respeto de los enanos, suelen ser tratados de forma paternalista, tal y como si fueran sus hermanos mayores o sus padres. Los elfos son friamente respetados y debidos a historias anteriores mantienen un cortes distanciamiento. Sienten desprecios por los trasgos y un odio profundo por los orcos','res/mipmap/enano.png');\n");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Humanos',70,16,35,60,0.90,1.20,'Aprendizaje rápido +2, Punto de Fortuna +1','Los humanos son una de las especies que más cómoda se encuentra junto a representantes de las demás.','res/mipmap/humano.png');\n");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Gnomos',70,12,35,90,1.20,2.30,'\"Ágil (+1 Destreza)\", \"Inteligente (+1 Inteligencia)\", \"Sentidos finos (+5 a la pericia de olfatear, saborear y escuchar)\", \"Débil (-1 Fuerza)\", \"+1 Punto de Fortuna\"','Los gnomos, para sus correrías, prefieren a humanos y elfos, y se llevan perfectamente bien con medianos. Con respecto los medianos, los soportan hasta que empiezan a ser paternalistas. A los orcos les temen y no comprenden su brutalidad, mientras que a los trasgos oscila de un extremos a otro; ya que les consideran excelentes compañeros para gastar bromas pero piensan que las bromas de los trasgos son crueles','res/mipmap/gnomo.png');\n");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Medianos',120,22,35,60,0.90,1.30,'\"Habilidoso (+1 Destreza)\", \"Débiles (-1 Fuerza)\", \"Subterráneo (visión en la infraoscuridad, +5 a orientarse bajo la superficie)\", \"Resistente a la magia (+2 a todas las TS contra efectos mágicos)\", \"+1 Punto de Fortuna\"','Los mejores compañeros de viaje para los medianos son los gnomos, auque tambien aceptan agradablemente a los medianos. No les desagrada viajar con elfos y humanos pero consideran que ambas son un tanto estiradas y preocupadas por todo','res/mipmap/medianos.png');\n");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Orcos',50,12,60,120,1.20,1.80,'\"Fuerte (+1 Fuerza)\", \"Robusto (+1 Constitución)\", \"Visión Oscura (visión en la infraoscuridad)\", \"Sentidos finos (+5 a la pericia de olfatear, saborear y escuchar)\", \"Lerdo (-1 Inteligencia)\", \"Debilidad ante el Sol (-3 a cualquier tirada con una fuerte luz solar)\"','Los orcos prefieren, de todas las Especies, a los humanos como compañeros, aunque los consideran débiles y más bien blanditos. Sin embargo, aprecian sus cualidades militares. Para el resto de las Especies, la opinión decae bastante. A los elfos y enanos los desprecian, aunque reconocen el valor de los primeros y la fiereza de los últimos en batalla. A los gnomos y medianos los aborrecen, y al igual que a los trasgos, consideran que solo sirven como esclavos o como prendas para los sacrificios. El caso de los trasgos merece una explicación aparte ya que a su desprecio unen su profundo odio por la humillación sufrida por sus antepasados al ser expulsados por los trasgos de sus territorios en el pasado.','res/mipmap/orco.png');\n");

        db.execSQL("insert into tableEspecies \n" +
                "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                "        VALUES\n" +
                "        ('Trasgos',50,12,30,70,0.80,1.50,'\"Ágil (+1 Destreza)\", \"Visión Oscura (Visión en la infraoscuridad)\", \"Sentidos finos (+5 a la pericia de olfatear, saborear y escuchar)\", \"Flojo (-1 Constitución) y +1 Punto de Fortuna.\"','Temen y odian a los orcos casi tanto como estos les desprecian. Como compañeros de aventura, los trasgos prefieren con mucho a los humanos. El sentimiento no es recíproco, y los humanos suelen despreciarlos en su mayoría. Con el resto de las razas las relaciones no suelen ser mucho mejores. Los trasgos desconfían mucho de los enanos y los elfos. Los gnomos y los medianos suelen ser vistos como seres inferiores.','assets/imgs/trasgo.png');\n");
    }

    public void onUpgrade (SQLiteDatabase db, int version1, int version2){
        db.execSQL("drop table if exists tableEspecies");
        onCreate(db);
    }
}
