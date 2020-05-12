/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.EventListener;
import Beans.*;

/**
 *
 * @author Simon
 */
public interface BoatEventListener extends EventListener{
    void boatEventDetected(BoatEvent e);
}
