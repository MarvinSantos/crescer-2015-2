

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClienteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClienteTest
{
    @Test
    public void clienteCriadoComDadosIniciais(){
        Cliente cliente = new Cliente("Joao", "Endereco1", "8888-9999");
        
        assertEquals("Joao", cliente.getNome());
        assertEquals("Endereco1", cliente.getEndereco());
        assertEquals("8888-9999", cliente.getTelefone());
    }
    
}
