/**
 * Exemplo de Intent para enviar eventos para o CALENDAR do Google
 * ver documentação em: https://
 * Cria-se uma Intent 'intent' inserção 'ACITION_INSERT', que conterá 'CONTENT_URI' do tipo
 * CALENDAR.
 * Cria-se um putExtra() para inserir dados dentro da variável 'content' que será
 * responsável por enviar estes dados para o calendário do Google.
 */
package com.ivamotelo.agendaapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.* // importação de todos os eventos do calendar
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Três formas de declarar um componente, no caso um Button
         * 1- : Button
         * 2 - <Button>
         * 3 - 'as Button'
         */
        val btn_send_event : Button = findViewById<Button>(R.id.btn_send_event) as Button
        btn_send_event.setOnClickListener{

            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CONTENT_URI)
                .putExtra(TITLE, "BootCamp Carrefur")
                .putExtra(EVENT_LOCATION, "On line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis() + (60*60*1000)) // 1hora em milisegundos
            startActivity(intent)
        }
    }
}