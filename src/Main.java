import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o diretorio do arquivo: ");
        String path = sc.next();

        Map<String, Integer> votos = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();

            while (linha != null){
                String[] retorno = linha.split(",");
                String nome = retorno[0];
                Integer contador = Integer.valueOf(retorno[1]);

                if (votos.containsKey(nome)){
                    Integer votosAtual = votos.get(nome);
                    votos.put(nome, contador + votosAtual);
                } else {
                    votos.put(nome, contador);
                }

                linha = br.readLine();
            }

            votos.entrySet().stream()
                    .forEach(x -> System.out.printf("%s : %s%n", x.getKey(), x.getValue()));

        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}