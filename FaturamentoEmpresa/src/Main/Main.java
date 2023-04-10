package Main;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Model.Faturamento;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        List<Faturamento> dias = new ArrayList<Faturamento>();

      
        	String caminho = "src/dados.json";
        	FileReader reader = new FileReader(caminho);

            Type type = new TypeToken<List<Faturamento>>(){}.getType();
            dias = gson.fromJson(reader, type);

            reader.close();
        
            double menorFaturamentoTotal = Double.MAX_VALUE;
            for (Faturamento dia : dias) {
                if (dia.getValor() < menorFaturamentoTotal) {
                    menorFaturamentoTotal = dia.getValor();
                }
            }

            double menorFaturamentoSem = Double.MAX_VALUE;
            for (Faturamento dia : dias) {
                if (dia.getValor() < menorFaturamentoSem && dia.getValor() != 0) {
                    menorFaturamentoSem = dia.getValor();
                }
            }

            double maiorFaturamento = Double.MIN_VALUE;
            for (Faturamento dia : dias) {
                if (dia.getValor() > maiorFaturamento) {
                    maiorFaturamento = dia.getValor();
                }
            }

            double somaFaturamento = 0.0;
            int numDiasComFaturamento = 0;
            for (Faturamento dia : dias) {
                if (dia.getValor() > 0) {
                    somaFaturamento += dia.getValor();
                    numDiasComFaturamento++;
                }
            }
            double meFaturamento = somaFaturamento / numDiasComFaturamento;

            int numDiasAcimaDaMedia = 0;
            for (Faturamento dia : dias) {
                if (dia.getValor() > meFaturamento) {
                    numDiasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento ignorando os dias fechados:  " + menorFaturamentoSem);
            System.out.println("Menor valor de faturamento: " + menorFaturamentoTotal);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + numDiasAcimaDaMedia);

      
    }
}