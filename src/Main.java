import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner leitorDados = new Scanner(System.in);

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de java");
        mentoria1.setDescricao("descrição mentoria java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Mentoria de QA");
        mentoria2.setDescricao("descrição mentoria QA");
        mentoria2.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp Java Developer");
        bootcamp1.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria1);

        Dev devRayne = new Dev();
        devRayne.setNome("Rayne");
        devRayne.inscreverBootcamp(bootcamp1);
//        System.out.println("Conteúdos Inscritos Rayne:" + devRayne.getConteudosInscritos());
        devRayne.progredir();
        devRayne.progredir();
//        System.out.println("-");
//        System.out.println("Conteúdos Inscritos Rayne:" + devRayne.getConteudosInscritos());
//        System.out.println("Conteúdos Concluídos Rayne:" + devRayne.getConteudosConcluidos());
//        System.out.println("XP:" + devRayne.calcularTotalXp());
//
//        System.out.println("-------");

        Dev devPaulo = new Dev();
        devPaulo.setNome("Paulo");
        devPaulo.inscreverBootcamp(bootcamp1);
//        System.out.println("Conteúdos Inscritos Paulo:" + devPaulo.getConteudosInscritos());
        devPaulo.progredir();
        devPaulo.progredir();
        devPaulo.progredir();
//        System.out.println("-");
//        System.out.println("Conteúdos Inscritos Paulo:" + devPaulo.getConteudosInscritos());
//        System.out.println("Conteúdos Concluidos Paulo:" + devPaulo.getConteudosConcluidos());
//        System.out.println("XP:" + devPaulo.calcularTotalXp())

        int opcao = ImprimirMenu();

        switch (opcao){
            case 0:
                System.exit(0);
            case 1:
                System.out.println("Digite o nome do(a) desenvolvedor(a):");
                String nomeDev = leitorDados.next();
                Dev desenvolvedor = new Dev(nomeDev);
                System.out.println("Desenvolvedor Cadastrado(a): " +desenvolvedor.toString());
                break;
            case 2:
                System.out.println("Digite o titulo do curso:");
                String tituloCurso = leitorDados.next();
                System.out.println("Digite a carga horaria do curso:");
                int cargaHorariaCurso = leitorDados.nextInt();
                System.out.println("Digite a descricao do curso:");
                String descricaoCurso = leitorDados.next();
                Curso curso = new Curso();
                curso.setTitulo(tituloCurso);
                curso.setCargaHoraria(cargaHorariaCurso);
                curso.setDescricao(descricaoCurso);
                System.out.println("Curso Cadastrado(a): " + curso.toString());
                break;
            case 3:
                System.out.println("Digite o titulo da mentoria:");
                String tituloMentoria = leitorDados.next();
                System.out.println("Digite a descricao da mentoria:");
                String descricaoMentoria = leitorDados.next();
                Mentoria mentoria = new Mentoria();
                mentoria.setTitulo(tituloMentoria);
                mentoria.setDescricao(descricaoMentoria);
                mentoria.setData(LocalDate.now());
                System.out.println("Mentoria Cadastrado(a): " + mentoria.toString());
                break;
            case 4:
                System.out.println("Digite o nome do bootcamp:");
                String nomeBootcamp = leitorDados.next();
                System.out.println("Digite a descricao do bootcamp:");
                String descricaoBootcamp = leitorDados.next();
                Bootcamp bootcamp = new Bootcamp();
                bootcamp.setNome(nomeBootcamp);
                bootcamp.setDescricao(descricaoBootcamp);
                Set<Conteudo> conteudos = new LinkedHashSet<Conteudo>();
                bootcamp.getConteudos().add(curso1);
                bootcamp.getConteudos().add(curso2);
                bootcamp.getConteudos().add(mentoria1);
                bootcamp.getDevsInscritos().add(devRayne);
                bootcamp.getDevsInscritos().add(devPaulo);
                System.out.println("Bootcamp Cadastrado(a): " + bootcamp.toString());
                break;
            case 5:
                Bootcamp bootcampNovo = new Bootcamp();
                bootcampNovo.getDevsInscritos().add(devRayne);
                System.out.println("Dev inscrito no Bootcamp: " + bootcampNovo.getDevsInscritos());
                break;
            case 6:
                System.out.println("Progredir Dev no bootcamp:");
                devRayne.progredir();
                System.out.println("XP do Dev: " + devRayne.calcularTotalXp());
                break;
            case 7:
                System.out.println("Listar Conteudos inscritos do Dev:");
                System.out.println(devRayne.getConteudosInscritos());
                break;
            case 8:
                System.out.println("Listar Conteudos concluidos do Dev:");
                System.out.println(devRayne.getConteudosConcluidos());
                break;
            default:
                  System.out.println("Opção inválida");
          }

    }

    public static Integer ImprimirMenu(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Escolha a opção desejada: ");
        System.out.println("[1] - Cadastrar Desenvolvedor ");
        System.out.println("[2] - Cadastrar Curso ");
        System.out.println("[3] - Cadastrar Mentoria ");
        System.out.println("[4] - Cadastrar Bootcamp ");
        System.out.println("[5] - Inscrever Dev no Bootcamp ");
        System.out.println("[6] - Progredir Dev no Bootcamp ");
        System.out.println("[7] - Listar Conteudos Inscritos do Dev ");
        System.out.println("[8] - Listar Conteudos Concluidos do Dev");
        System.out.println("[0] - Sair ");
        return leitor.nextInt();
    }

}