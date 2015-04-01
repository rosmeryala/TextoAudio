/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetexto;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author thedarker
 */
public class Leer {

    private Voice voice;

    public void leerTexto(String mensaje) {
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        if (voice == null) {
            System.out.print("Error en la carga");
        }
        voice.speak(mensaje);
        voice.deallocate();
    }

}
