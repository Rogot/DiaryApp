package com.example.analizapp.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.example.analizapp.model.BloodPress;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class JUnitBloodPress {
    private static final String FILE    = "data.ser";

    private static final int    SYS_1   = 120;
    private static final int    SYS_2   = 130;
    private static final int    DIA_1   = 80;
    private static final int    DIA_2   = 90;
    private static final int    PLS_1   = SYS_1 - DIA_1;

    private static BloodPress measure_1 = null      ;
    private static BloodPress measure_2 = null      ;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        try {
            measure_1 = new BloodPress(SYS_1, DIA_1, PLS_1);
            measure_2 = new BloodPress(SYS_2, DIA_2, SYS_2 - DIA_2);

            FileOutputStream    fos = new FileOutputStream(FILE);
            ObjectOutputStream  oos = new ObjectOutputStream(fos);
            oos.writeObject(measure_1);
            oos.writeObject(measure_2);
            oos.close();

        } catch (Exception e){
            fail("Exception thrown during test: " + e.toString());
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //Delete file
        new File(FILE).delete();
    }

    @Test
    public void testSerialization()
    {
        try {
            FileInputStream     fis = new FileInputStream(FILE);
            ObjectInputStream   ois = new ObjectInputStream(fis);
            BloodPress measure_1 = (BloodPress) ois.readObject();
            BloodPress measure_2 = (BloodPress) ois.readObject();
            ois.close();

            assertEquals(measure_1.getSystolicValue(), SYS_1);
            assertEquals(measure_1.getDiastolicValue(), DIA_1);
            assertEquals(measure_1.getPulseValue(), PLS_1);
            assertEquals(measure_2.getSystolicValue(), SYS_2);
            assertEquals(measure_2.getDiastolicValue(), DIA_2);
            assertEquals(measure_2.getPulseValue(), SYS_2 - DIA_2);

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.toString());
        }
    }
}
