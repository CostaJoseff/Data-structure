package sorting.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;

public class InitTest {

	protected AbstractSorting<Integer> sort;
	private Integer[] arrayPar;
	private Integer[] arrayImpar;
	private Integer[] arrayVazio;
	private Integer[] arrayRepetido;
	private Integer[] arrayIgual;
	protected Integer[] arrayGigante;
	protected Integer[] giganteOrdenado;
	private String exceptMessage = "Your code dont throw a Illegal Argument Exception.";
	
	@Before
	public void setUp(){
		this.arrayPar =      new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		this.arrayImpar =    new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36};
		this.arrayVazio =    new Integer[] {};
		this.arrayRepetido = new Integer[] {4, 9, 3, 4, 0, 5, 1, 4};
		this.arrayIgual =    new Integer[] {6, 6, 6, 6, 6, 6};
		//preencheArray(1000000);
		//this.sort = new MergeSort<Integer>();
	}
	
	protected void preencheArray(int tamanho) {
		this.arrayGigante = new Integer[tamanho];
		Random rd = new Random();
		for (int i = 0; i < tamanho; i++) {
			this.arrayGigante[i] = rd.nextInt(1000000);
		}
		this.giganteOrdenado = Arrays.copyOf(arrayGigante, arrayGigante.length);
		Arrays.sort(this.giganteOrdenado);
	}
	
	protected void testeGlobal(Integer[] array) {
		Integer[] ordenado = {};
		if (array.length > 0) {
			ordenado = Arrays.copyOf(array, array.length);
			Arrays.sort(ordenado);
		}
		this.sort.sort(array);
		assertArrayEquals(ordenado, array);
	}
	
	protected void testeGlobal(Integer[] desordenado, Integer[] ordenado) {
		this.sort.sort(desordenado);
		assertArrayEquals(ordenado, desordenado);
	}
	
	@Test
	public void testArrayPar() {
		testeGlobal(this.arrayPar);
	}
	
	@Test
	public void testArrayImpar() {
		testeGlobal(this.arrayImpar);
	}
	
	@Test
	public void testArrayVazio() {
		try {
			testeGlobal(this.arrayVazio);
			fail(exceptMessage);
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	public void testArrayRepetido() {
		testeGlobal(this.arrayRepetido);
	}
	
	@Test
	public void testArrayIgual() {
		testeGlobal(this.arrayIgual);
	}
	
	@Test
	public void testExceptions() {
		try {
			this.sort.sort(new Integer[] {}, 0, 0);
			fail(exceptMessage + ": Array length == 0");
		} catch (IllegalArgumentException iae) {}
		try {
			this.sort.sort(this.arrayPar, -4, 3);
			fail(exceptMessage + ": Left index < 0");
		} catch (IllegalArgumentException iae) {}
		try {
			this.sort.sort(this.arrayPar, this.arrayPar.length + 3, this.arrayPar.length + 5);
			fail(exceptMessage + ": (Left index || Right index) > Array length");
		} catch (IllegalArgumentException iae) {}
		try {
			this.sort.sort(this.arrayPar, this.arrayPar.length - 1, 0);
			fail(exceptMessage + ": Left index > Right index");
		} catch (IllegalArgumentException iae) {}
	}
}
