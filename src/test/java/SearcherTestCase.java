import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.uem.Searcher;

public class SearcherTestCase {
    Searcher searcher;

    @BeforeEach 
    public void setUp() {
        searcher = new Searcher();
    }

    @Test
    public void testSearchWord (){
        List<String> colores = new ArrayList<>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");

        boolean coincidencia = searcher.searchWord("verde", colores);
        assertEquals(true, coincidencia);
        
        boolean sinCoincidencia = searcher.searchWord("amarillo", colores);
        assertEquals(false, sinCoincidencia);
    }

    @Test 
    public void testGetWordByIndex(){
        List<String> animales = new ArrayList<>();
        animales.add("perro");
        animales.add("gato");
        animales.add("mofeta");

        String animalEncontrado = searcher.getWordByIndex(animales, 1);
        assertEquals("gato", animalEncontrado);
        
        // Probamos índice demasiado grande y también negativo (como pide el enunciado)
        String fueraDeRangoPositivo = searcher.getWordByIndex(animales, 10);
        assertEquals(null, fueraDeRangoPositivo);
        
        String fueraDeRangoNegativo = searcher.getWordByIndex(animales, -2);
        assertEquals(null, fueraDeRangoNegativo);
    }

    @Test 
    public void testSearchByPrefix (){
        List<String> vehiculos = new ArrayList<>();
        vehiculos.add("lancha");
        vehiculos.add("autobus");
        vehiculos.add("autopista");
        vehiculos.add("bicicleta");
        vehiculos.add("barco");






        List<String> conPrefijo = searcher.searchByPrefix("auto", vehiculos);
        assertEquals(2, conPrefijo.size());
        
        List<String> sinPrefijo = searcher.searchByPrefix("moto", vehiculos);
        assertEquals(0, sinPrefijo.size());
    }
    
    @Test 
    public void testFilterByKeyword () {
        List<String> conceptos = new ArrayList<>();
        conceptos.add("Programacion");
        
        conceptos.add("Programa");
        conceptos.add("Diseño");

        List<String> filtrados = searcher.filterByKeyword("Programa", conceptos);
        assertEquals(2, filtrados.size());
        
        List<String> noFiltrados = searcher.filterByKeyword("Web", conceptos);
        assertEquals(0, noFiltrados.size());
    }
    
    @Test
    public void testSearchExactPhrase (){
        List<String> textos = new ArrayList<>(); 
        textos.add("Hola wenas tardes");
        textos.add("Tengo muchas tareas de la universidad");
        textos.add("Tengo examen de ing.software");

        boolean existeFrase = searcher.searchExactPhrase("Tengo muchas tareas de la universidad", textos); 
        assertEquals(true, existeFrase);
        
        boolean noExisteFrase = searcher.searchExactPhrase(" En verdad no tengo tantas tareas", textos); 
        assertEquals(false, noExisteFrase);
    }
}