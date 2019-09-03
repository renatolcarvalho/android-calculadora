package br.edu.ifsp.scl.calculadorasdmkt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var concatLcd = true

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onClickButNum(clicked: View?){
        if (!concatLcd || lcdTv.text.toString() == "0"){
            lcdTv.text = ""
        }

        lcdTv.append((clicked as Button).text.toString())

        concatLcd = true
    }

    fun onClickButAdicao(clicked: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.ADICAO
        ).toString()

        concatLcd = false
    }

    fun onClickButSubtracao(clicked: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.SUBTRACAO
        ).toString()

        concatLcd = false
    }

    fun onClickButMultiplicacao(clicked: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.MULTIPLICACAO
        ).toString()

        concatLcd = false
    }

    fun onClickButDivisao(clicked: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.DIVISAO
        ).toString()

        concatLcd = false
    }

    fun onClickButResultado(clicked: View?){
        lcdTv.text = Calculadora.calcula(
            lcdTv.text.toString().toFloat(),
            Operador.RESULTADO
        ).toString()

        concatLcd = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickZeroPonto(view: View?) {
        when (view){

            zeroBt -> {
                if (!concatLcd) {
                    lcdTv.text = ""
                }
                lcdTv.append((view as Button).text.toString())
                concatLcd = true
            }

            pontoBt -> {
                if (!lcdTv.text.toString().contains(".")){
                    if (!concatLcd) {
                        lcdTv.text = "0"
                    }
                    lcdTv.append(".")
                    concatLcd = true
                }
            }
        }
    }

    fun onClickAC(clicked: View?){
        lcdTv.text = "0"
        concatLcd = true
        Calculadora.cleanAll()
    }

    fun onClickC(clicked: View?){
        lcdTv.text = "0"
        concatLcd = true
    }

    fun onClickPorcentagem(clicked: View?){
        lcdTv.text = Calculadora.calculaPorcentagem(
            lcdTv.text.toString().toFloat()
        ).toString()

        concatLcd = true
    }

    fun onClickRaizQuadrada(clicked: View?){
        lcdTv.text = Calculadora.calculaRaiz(
            lcdTv.text.toString().toFloat()
        ).toString()

        concatLcd = true
    }
}