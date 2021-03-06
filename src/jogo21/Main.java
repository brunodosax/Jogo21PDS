/**
 * <copyright>
 *
 * Copyright 2012 Burno Vicelli <brunodosax@hotmail.com> * Este programa e todos
 * os materiais que o acompanham estão disponibilizados sob a licença GPL versão
 * 3, que acompanha esta distribuição e está disponível em
 * http://www.gnu.org/licenses/gpl.html </copyright>
 */
package jogo21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import pds.Baralho;
import java.util.ArrayList;

/**
 *
 *
 * Universidade Federal do Pampa Graduação: Engenharia de Software Disciplina:
 * Práticas de Desenvolvimento de Software Professor: Wagner de Melo Reck
 * Semestre: 5° - 2012/01
 *
 * @author Bruno Vicelli
 * @Version 1.0 @Date 27/09/2012
 */
public class Main {

    /**
     * Método que faz o jogo funcionar
     *
     * @param args
     */
    public static void main(String[] args) {


        Jogador jogador1 = new Jogador("");
        Jogador jogador2 = new Jogador("");
        Baralho baralho = new Baralho();
        baralho.embaralhar();

        Jogo jogo = new Jogo(jogador1, jogador2);
        jogo.defineNomeJogador(jogador1, jogador2);

        jogador1.addCarta(baralho.getPrimeiraCarta());
        jogador2.addCarta(baralho.getPrimeiraCarta());
        System.out.println(jogador1.getNome() + " esta com: " + jogo.calculaPontuacao(jogador1) + " pontos");
        System.out.println(jogador2.getNome() + " esta com: " + jogo.calculaPontuacao(jogador2) + " pontos");

        BufferedReader entrada;
        entrada = new BufferedReader(new InputStreamReader(System.in));


        Jogador jogador = null;
        String resposta = "";
        while (jogo.verificaVencedor(jogador1, jogador2) == null) {
            try {
                jogador = jogo.trocaJogador();
            } catch (Exception e) {
                System.out.println("erro ao trocar jogador");
                e.printStackTrace();
            }
            System.out.println("Digite 's' para pegar mais uma carta: "
                    + " " + jogador.getNome() + "!");

            try {
                resposta = entrada.readLine();
            } catch (Exception e) {
                System.out.println("erro ao ler");
                e.printStackTrace();
            }
            if (resposta.equals("s")) {
                jogador.addCarta(baralho.getPrimeiraCarta());
            }

            System.out.println(jogador1.getNome() + " esta com: " + jogo.calculaPontuacao(jogador1) + " pontos");
            System.out.println(jogador2.getNome() + " esta com: " + jogo.calculaPontuacao(jogador2) + " pontos");
        }
    }
}
