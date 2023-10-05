import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o diretorio do arquivo: ");
        String path = sc.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();

            while (linha != null){
                System.out.println(linha);

                linha = br.readLine();
            }
        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}