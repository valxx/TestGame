package edu.bouyaka.testGame;

import edu.bouyaka.engine.*;
import edu.bouyaka.engine.concreted.*;
import edu.bouyaka.engine.abstracted.*;

public class TestGame {

	public static Gengine engine;

	public static void main(String[] args) {
		// Initialisation du moteur
		engine = new Gengine();

		/*
		 * Initialisation et configuration des diff�rents objets de base
		 */

		// Chargement des fichiers de configuration
		SysConfig basic = new SysConfig("base.cfg", engine);
		SpritesConfig spritesId = new SpritesConfig("spritesId.cfg", engine);

		// Lecture de la configuration
		basic.load();
		spritesId.load();

		// Cr�ation d'une interface
		engine.addInterface(0);
		engine.Interface(0).enabled = true;

		// Cr�ation d'un bouton affichant la console
		engine.addButton(0);
		TextBox console = new TextBox();
		engine.replaceButton(0, console);
		engine.Button(0).enabled = true;
		engine.Button(0).setRPos(engine.displayWidth / 2,
				engine.displayHeight - engine.displayHeight / 90);
		engine.Button(0)
				.setSize(engine.displayWidth, engine.displayHeight / 45);
		engine.Button(0).replaceText("Console initialis�e");
		engine.Interface(0).addButton(engine.Button(0), 0);

		// Cr�ation d'un bouton affichant les fps
		engine.addButton(1);
		engine.Button(1).enabled = true;
		engine.Button(1).setRPos(engine.displayWidth / 90,
				engine.displayHeight / 90);
		engine.Button(1).setSize(engine.displayWidth / 45,
				engine.displayHeight / 45);
		engine.Interface(0).addButton(engine.Button(1), 1);

		// Cr�ation d'un bouton affichant la r�vision du moteur/jeu
		engine.addButton(2);
		engine.Button(2).enabled = true;
		engine.Button(2).setRPos(
				engine.displayWidth - engine.displayWidth / 50,
				engine.displayHeight / 90);
		engine.Button(2).setSize(engine.displayWidth / 25,
				engine.displayHeight / 45);
		engine.Button(2).replaceText(engine.rev);
		engine.Interface(0).addButton(engine.Button(2), 2);

		// G�n�ration de l'entit� repr�sentant le joueur 1
		engine.addPlayer(0);
		engine.Player(0).enabled = true;
		engine.Player(0).setRPos((int) (Math.random() * engine.displayWidth),
				(int) (Math.random() * engine.displayHeight));
		engine.Player(0).setSpriteId(0);
		engine.Player(0).setUpKey(90);
		engine.Player(0).setDownKey(83);
		engine.Player(0).setLeftKey(81);
		engine.Player(0).setRightKey(68);

		// G�n�ration de l'entit� repr�sentant le joueur 2
		engine.addPlayer(1);
		engine.Player(1).enabled = true;
		engine.Player(1).setRPos(engine.displayWidth / 2,
				engine.displayHeight / 2);
		engine.Player(1).setSpriteId(1);
		engine.Player(1).setUpKey(38);
		engine.Player(1).setDownKey(40);
		engine.Player(1).setLeftKey(37);
		engine.Player(1).setRightKey(39);

		engine.setInterfaceAmount(2);
		engine.addInterface(1);
		engine.addButton(3);
		engine.Button(3).replaceText("Quitter");
		engine.Button(3).enabled = true;
		engine.addButton(4);
		engine.Button(4).replaceText("Jouer");
		engine.Button(4).enabled = true;
		engine.Button(3).setRPos(
				engine.displayWidth / 2 - engine.displayWidth / 50,
				engine.displayHeight / 2 - engine.displayHeight / 90);
		engine.Button(4).setRPos(
				engine.displayWidth / 2 - engine.displayWidth / 50,
				engine.displayHeight / 2 - 32 - engine.displayHeight / 90);

		engine.Button(3).setSize(engine.displayWidth / 25,
				engine.displayHeight / 45);
		engine.Button(4).setSize(engine.displayWidth / 25,
				engine.displayHeight / 45);

		engine.Interface(1).addButton(engine.Button(3), 0);
		engine.Interface(1).addButton(engine.Button(4), 1);
		engine.Interface(1).enabled = true;

		// G�neration et Positionnement al�atoire des entit�es de test
		for (int id = 0; id < engine.npcAmount; id++) {
			engine.addNpc(id);
			engine.Npc(id).enabled = true;

			engine.Npc(id).setRPos(Math.random() * engine.screenWidth,
					Math.random() * engine.screenHeight);

			engine.Npc(id).setSpriteId(2);

		}

		engine.start();
		engine.display.setCursor(engine.Sprite(6));
		while (true && !engine.keyboard.keyP(27)) {
			engine.Button(1).replaceText(String.valueOf(engine.shownFps));
			engine.update();
		}
		System.exit(0);
	}
}
