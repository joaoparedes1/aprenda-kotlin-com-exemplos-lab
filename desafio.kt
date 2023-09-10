enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val matricula: String, val email: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach {
            inscritos.add(it)
        }
    }

    fun ImprimeDetalhesFormacao() {
        println(nome)
        println("Nivel: $nivel")
        println("\nConteudos: ")

        conteudos.forEachIndexed { index, conteudo ->
            println("${index+1}- ${conteudo.nome}")
            println("${conteudo.nivel}\t${conteudo.duracao}Hrs")
            println("________________________")
        }
    }

    fun ImprimeAlunosInscritos() {
        println("\nAlunos inscritos: ")
        inscritos.sortBy { it.nome }
        inscritos.forEachIndexed { index, aluno ->
            println("${index+1}) ${aluno.nome}, ${aluno.matricula} ")
        }
    }

}

fun main() {

    val conteudosAndroid = listOf(
        ConteudoEducacional("Versionamento de Codigo com Git", Nivel.BASICO,2),
        ConteudoEducacional("Introdução de programação Kotlin", Nivel.BASICO,1),
        ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin", Nivel.BASICO,2),
        ConteudoEducacional("Tratamento de exceções em Kotlin", Nivel.INTERMEDIARIO,2),
        ConteudoEducacional("Android Jetpack", Nivel.DIFICIL,10),
    )

    val formacao = Formacao("Formação Desenvolvedor Android", Nivel.INTERMEDIARIO, conteudosAndroid)

    formacao.matricular(
        Usuario("Joao Paredes", "123456789", "jmparedesx@gmail.com"),
        Usuario("Manoel da Silva", "987654321", "Manoel@hotmail.com"),
        Usuario("Maria Gomez", "16161616", "Maria@yahoo.com"),
        Usuario("Ana Paula", "1010101010", "Ana@yahoo.com")
    )

    formacao.ImprimeDetalhesFormacao()
    formacao.ImprimeAlunosInscritos()
}
