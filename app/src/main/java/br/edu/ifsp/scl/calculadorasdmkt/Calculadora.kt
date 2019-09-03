package br.edu.ifsp.scl.calculadorasdmkt

enum class Operador {
    RESULTADO, ADICAO, SUBTRACAO, MULTIPLICACAO, DIVISAO
}

object Calculadora {

    var operando: Float = 0.0f
    var operador: Operador = Operador.RESULTADO

    fun calculaRaiz(valor:Float) : Float{
        return Math.sqrt(valor.toDouble()).toFloat()
    }

    fun calculaPorcentagem(valor: Float) : Double{
        return  valor * 0.01
    }

    fun calcula(valor: Float, operador: Operador): Float {
        when (this.operador) {
            Operador.RESULTADO -> operando = valor
            Operador.ADICAO -> operando += valor
            Operador.SUBTRACAO -> operando -= valor
            Operador.MULTIPLICACAO -> operando *= valor
            Operador.DIVISAO -> operando /= valor
        }

        this.operador = operador
        return operando
    }

    fun cleanAll() {
        operando = 0.0f
    }
}