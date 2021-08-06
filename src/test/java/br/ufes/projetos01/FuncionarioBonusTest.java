package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author clayton
 */
public class FuncionarioBonusTest {

    public FuncionarioBonusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void CT001_Old() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        double salarioEsperado = 2500.00;

        assertEquals(salarioEsperado, funcionario.getSalarioBase(), 0.001);
    }

    @Test
    public void CT002_Old() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2650.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT003_Old() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(101);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2950.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT004_Old() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(151);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 3150.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
     @Test
    public void CT005_Old() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(51);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2800.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    //Novos testes, segundo a planilha
    @Test
    public void CT001() throws Exception {
        
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#1 Informe um nome válido"));
        
        Funcionario funcionario = new Funcionario(null, 2000.00, "Supervisor");
        funcionario.setDistanciaMoradia(53);
        funcionario.setFaltas(7);
    }
    
    
    @Test
    public void CT002() throws Exception {
        
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#3 O salário base deve ser >= R$ 998,00"));
        
        Funcionario funcionario = new Funcionario("Cléber Machado", 250.00, "Programador");
        funcionario.setDistanciaMoradia(113);
        funcionario.setFaltas(1);
    }
    
    @Test
    public void CT003() throws Exception {
        
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#2 Informe um cargo válido"));
        
        Funcionario funcionario = new Funcionario("Andre Heinning", 2500.00, null);
        funcionario.setDistanciaMoradia(12);
        funcionario.setFaltas(37);
    }
    
    @Test
    public void CT004() throws Exception {
        Funcionario funcionario = new Funcionario("Alexandre", 1000.00, "Programador");
        funcionario.setDistanciaMoradia(239);
        funcionario.setFaltas(0);
        
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 1600.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT005() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#5 A distância é inválida"));

        Funcionario funcionario = new Funcionario("Clovis", 1300.00, "PROGRAMADOR");
        funcionario.setDistanciaMoradia(-5);
    }

    @Test
    public void CT006() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#6 O total de faltas é inválido"));

        Funcionario funcionario = new Funcionario("Alfredo", 3200.00, "PROGRAMADOR");

        funcionario.setFaltas(-7);
    }

    @Test
    public void CT007() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(is("\n#4 O nome possui caracteres inválidos"));

        Funcionario funcionario = new Funcionario("Alexandre77", 1900.00, "Gerente");

    }

    @Test
    public void CT008() throws Exception {

        Funcionario funcionario = new Funcionario("Cláudio Adão", 2200.00, "Supervisor");

        funcionario.setFaltas(3);
        funcionario.setDistanciaMoradia(23);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2324.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
}
