package mx.edu.itesca.operaciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Instanciar Objetos
        val lado1=findViewById<EditText>(R.id.etNum1)
        val lado2=findViewById<EditText>(R.id.etNum2)
        val lado3=findViewById<EditText>(R.id.etNum3)
        val tipo=findViewById<TextView>(R.id.tvTipo)
        val verificar=findViewById<Button>(R.id.btnCalcular)
        //Programar el evento click del boton
        verificar.setOnClickListener {
            val A=lado1.text.toString().toDoubleOrNull()
            val B=lado2.text.toString().toDoubleOrNull()
            val C=lado3.text.toString().toDoubleOrNull()
            //validar vacio o nulo
            if(A==null||B==null||C==null){
                tipo.text="Ingrese valores validos"
                return@setOnClickListener
            }
            //LLamar a la funcion
            tipo.text=determinarTriangulo(A,B,C)


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
//Crear funciones
fun determinarTriangulo(ladoA:Double, ladoB:Double, ladoC:Double): String{
    if(ladoA<=0||ladoB<=0||ladoC<=0){
        return "todos los lados deben ser mayor a 0"
    }
    if(formarTriangulo(ladoA,ladoB,ladoC)){
        if(ladoA==ladoB && ladoA==ladoC){
            return "triangulo equilatero"
        }
        if((ladoA==ladoB && ladoA!=ladoC)||(ladoA==ladoC && ladoA!=ladoB)||(ladoB==ladoC
                    && ladoB!=ladoA)){
            return "triangulo isoceles"
        }
        if(ladoA!=ladoB && ladoB!=ladoC){
            return "triangulo escaleno"
        }
        return " "
    }
    else{
        return "No es posible formar un triangulo"
    }
}
fun formarTriangulo(ladoA:Double, ladoB:Double, ladoC:Double): Boolean{
    return (ladoA+ladoB)>ladoC&&(ladoB+ladoC)>ladoA&&(ladoA+ladoC)>ladoB

}