package section;

import java.util.LinkedList;

import basics.Level;
import basics.Point;
import basics.Text;
import main.Kompass;
import main.Labyrinth;
import main.Objekt;
import models3D.DekoKreuz;
import models3D.DekoSchild;
import models3D.Tuer;
import path.*;

public class AbschnittD extends Objekt
{
  protected LinkedList<Lab>    waende   = new LinkedList<Lab>();    // Objekte die eine oder mehrere Waende des Spiels
                                                                    // beinhalten
  
  protected LinkedList<Objekt> steine   = new LinkedList<Objekt>(); // Objekte wie Ecksteine, Bodenplatten oder
                                                                    // Dekoartikel, die keinen direkten Einfluss haben
  
  protected LinkedList<Lab>    tueren   = new LinkedList<Lab>();    // Ausschliesslich Tueren, Tuerrahmen sind in der
                                                                    // List der Waende.
  
  protected LinkedList<Objekt> schalter = new LinkedList<Objekt>(); // Ausschliesslich Schalter
  
  public AbschnittD() // Gesamte Aufstellung des ersten Levels, ausgenommen des Mechanismusses DD1/DD2 sind alle im
                      // ersten Level enthaltenen Objekte hier zu finden.
  {
    waende.add(new LabTuer_L(new Level(1, 14)));
    waende.add(new LabEck_ru(new Level(-5, 21)));
    waende.add(new LabWeg_r_l(new Level(-4, 21)));
    waende.add(new LabEck_lo(new Level(-3, 21)));
    waende.add(new LabEck_ru(new Level(-3, 20)));
    waende.add(new LabEck_lu(new Level(-2, 20)));
    waende.add(new LabEck_ro(new Level(-2, 21)));
    waende.add(new LabWeg_r_l(new Level(-1, 21)));
    waende.add(new LabWeg_r_l(new Level(0, 21)));
    waende.add(new LabWeg_L(new Level(-5, 22)));
    waende.add(new LabWeg_r_l(new Level(0, 23)));
    waende.add(new LabWeg_r_l(new Level(-1, 23)));
    waende.add(new LabWeg_r_l(new Level(-2, 23)));
    waende.add(new LabWeg_r_l(new Level(-3, 23)));
    waende.add(new LabWeg_r_l(new Level(-4, 23)));
    waende.add(new LabEck_ru(new Level(-5, 23), true));
    waende.add(new LabWeg_o_u(new Level(-5, 24)));
    waende.add(new LabWeg_o_u(new Level(-5, 25)));
    waende.add(new LabWeg_o_u(new Level(-5, 26)));
    waende.add(new LabWeg_o_u(new Level(-5, 27)));
    waende.add(new LabEck_ro(new Level(-5, 28), true));
    waende.add(new LabWeg_U(new Level(-4, 28)));
    waende.add(new LabWeg_U(new Level(-3, 28)));
    waende.add(new LabWeg_U(new Level(-2, 28)));
    waende.add(new LabWeg_U(new Level(-1, 28)));
    waende.add(new LabWeg_U(new Level(0, 28)));
    waende.add(new LabWeg_r_l(new Level(-3, 27)));
    waende.add(new LabWeg_r_l(new Level(-2, 27)));
    waende.add(new LabWeg_r_l(new Level(-1, 27)));
    waende.add(new LabWeg_U(new Level(0, 27)));
    waende.add(new LabWeg_R(new Level(-4, 26)));
    waende.add(new LabWeg_R(new Level(-4, 25)));
    waende.add(new LabWeg_O(new Level(-3, 25)));
    waende.add(new LabWeg_r_l(new Level(-2, 25)));
    waende.add(new LabWeg_r_l(new Level(-1, 25)));
    waende.add(new LabWeg_U(new Level(0, 25)));
    waende.add(new LabWeg_r_l(new Level(1, 28)));
    waende.add(new LabEck_lo(new Level(2, 28)));
    waende.add(new LabEck_lu(new Level(2, 27)));
    waende.add(new LabWeg_L(new Level(1, 27)));
    waende.add(new LabWeg_o_u(new Level(1, 26)));
    waende.add(new LabWeg_o_u(new Level(1, 25)));
    waende.add(new LabWeg_o_u(new Level(1, 24)));
    waende.add(new LabWeg_o_u(new Level(1, 23)));
    waende.add(new LabEck_ru(new Level(1, 22), true));
    waende.add(new LabWeg_r_l(new Level(2, 22)));
    waende.add(new LabWeg_r_l(new Level(3, 22)));
    waende.add(new LabWeg_r_l(new Level(4, 22)));
    waende.add(new LabEck_lo(new Level(5, 22), true));
    waende.add(new LabWeg_R(new Level(5, 21)));
    waende.add(new LabEck_lu(new Level(5, 20), true));
    waende.add(new LabWeg_r_l(new Level(4, 20)));
    waende.add(new LabWeg_r_l(new Level(3, 20)));
    waende.add(new LabWeg_r_l(new Level(2, 20)));
    waende.add(new LabEck_ro(new Level(1, 20)));
    waende.add(new LabTuer_L(new Level(1, 21)));
    waende.add(new LabTuer_L(new Level(1, 28)));
    waende.add(new LabWeg_L(new Level(1, 19)));
    waende.add(new LabEck_ro(new Level(1, 18), true));
    waende.add(new LabWeg_r_l(new Level(2, 18)));
    waende.add(new LabWeg_r_l(new Level(3, 18)));
    waende.add(new LabWeg_R(new Level(5, 19)));
    waende.add(new LabWeg_o_u(new Level(5, 18)));
    waende.add(new LabWeg_o_u(new Level(5, 17)));
    waende.add(new LabWeg_o_u(new Level(5, 16)));
    waende.add(new LabWeg_o_u(new Level(1, 17)));
    waende.add(new LabWeg_o_u(new Level(1, 16)));
    waende.add(new LabEck_ru(new Level(1, 15), true));
    waende.add(new LabWeg_r_l(new Level(2, 15)));
    waende.add(new LabWeg_U(new Level(3, 16)));
    waende.add(new LabWeg_U(new Level(4, 16)));
    waende.add(new LabEck_lo(new Level(3, 15), true));
    waende.add(new LabDmgWeg_R(new Level(3, 14)));
    waende.add(new LabDmgWeg_R(new Level(3, 13)));
    waende.add(new LabWeg_r_l(new Level(2, 13)));
    waende.add(new LabWeg_L(new Level(1, 13)));
    waende.add(new LabDmgWeg_U(new Level(1, 13)));
    waende.add(new LabEck_ru(new Level(1, 12)));
    waende.add(new LabEck_ru(new Level(3, 12)));
    waende.add(new LabWeg_r_l(new Level(4, 12)));
    waende.add(new LabWeg_r_l(new Level(5, 12)));
    waende.add(new LabWeg_O(new Level(6, 12)));
    waende.add(new LabEck_ro(new Level(6, 13)));
    waende.add(new LabWeg_o_u(new Level(7, 13)));
    waende.add(new LabWeg_L(new Level(5, 14)));
    waende.add(new LabEck_ru(new Level(5, 15)));
    waende.add(new LabWeg_O(new Level(6, 15)));
    waende.add(new LabEck_lu(new Level(7, 15)));
    waende.add(new LabWeg_o_u(new Level(7, 16)));
    waende.add(new LabWeg_o_u(new Level(7, 17)));
    waende.add(new LabWeg_o_u(new Level(7, 18)));
    waende.add(new LabWeg_o_u(new Level(7, 19)));
    waende.add(new LabWeg_o_u(new Level(7, 20)));
    waende.add(new LabWeg_o_u(new Level(7, 21)));
    waende.add(new LabEck_ro(new Level(7, 22), true));
    waende.add(new LabWeg_U(new Level(8, 22)));
    waende.add(new LabEck_lo(new Level(9, 22), true));
    waende.add(new LabWeg_o_u(new Level(9, 21)));
    waende.add(new LabWeg_o_u(new Level(9, 20)));
    waende.add(new LabWeg_o_u(new Level(9, 19)));
    waende.add(new LabEck_ru(new Level(9, 18)));
    waende.add(new LabTuer_L(new Level(9, 17)));
    waende.add(new LabEck_ro(new Level(9, 16)));
    waende.add(new LabTuer_U(new Level(8, 16)));
    waende.add(new LabEck_ru(new Level(9, 15)));
    waende.add(new LabWeg_R(new Level(7, 14)));
    waende.add(new LabWeg_o_u(new Level(9, 13)));
    waende.add(new LabWeg_r_l(new Level(8, 12)));
    waende.add(new LabWeg_r_l(new Level(10, 16)));
    waende.add(new LabWeg_O(new Level(10, 18)));
    waende.add(new LabEck_lu(new Level(11, 18)));
    waende.add(new LabWeg_r_l(new Level(11, 16)));
    waende.add(new LabWeg_O(new Level(10, 15)));
    waende.add(new LabDmgWeg_O(new Level(11, 15)));
    waende.add(new LabWeg_O(new Level(12, 15)));
    waende.add(new LabWeg_O(new Level(12, 16)));
    waende.add(new LabWeg_o_u(new Level(13, 16)));
    waende.add(new LabWeg_o_u(new Level(13, 17)));
    waende.add(new LabWeg_o_u(new Level(13, 15)));
    waende.add(new LabWeg_R(new Level(13, 14)));
    waende.add(new LabWeg_o_u(new Level(13, 13)));
    waende.add(new LabWeg_o_u(new Level(13, 12)));
    waende.add(new LabEck_lu(new Level(13, 11)));
    waende.add(new LabEck_ru(new Level(12, 11)));
    waende.add(new LabWeg_L(new Level(12, 12)));
    waende.add(new LabWeg_U(new Level(12, 13)));
    waende.add(new LabWeg_r_l(new Level(11, 13)));
    waende.add(new LabWeg_U(new Level(10, 13)));
    waende.add(new LabDmgWeg_R(new Level(9, 12)));
    waende.add(new LabWeg_o_u(new Level(9, 11)));
    waende.add(new LabWeg_o_u(new Level(9, 10)));
    waende.add(new LabWeg_o_u(new Level(9, 9)));
    waende.add(new LabWeg_o_u(new Level(9, 8)));
    waende.add(new LabTuer_O(new Level(9, 8)));
    waende.add(new LabWeg_R(new Level(7, 11)));
    waende.add(new LabWeg_r_l(new Level(7, 10)));
    waende.add(new LabWeg_r_l(new Level(6, 10)));
    waende.add(new LabWeg_r_l(new Level(5, 10)));
    waende.add(new LabWeg_r_l(new Level(4, 10)));
    waende.add(new LabWeg_r_l(new Level(3, 10)));
    waende.add(new LabDmgWeg_U(new Level(2, 10)));
    waende.add(new LabEck_lu(new Level(2, 9)));
    waende.add(new LabEck_ru(new Level(1, 9)));
    waende.add(new LabWeg_L(new Level(1, 10)));
    waende.add(new LabWeg_L(new Level(1, 11)));
    waende.add(new LabWeg_r_l(new Level(8, 8)));
    waende.add(new LabWeg_r_l(new Level(7, 8)));
    waende.add(new LabWeg_r_l(new Level(6, 8)));
    waende.add(new LabWeg_r_l(new Level(5, 8)));
    waende.add(new LabEck_ro(new Level(4, 8)));
    waende.add(new LabWeg_L(new Level(4, 7)));
    waende.add(new LabWeg_U(new Level(3, 7)));
    waende.add(new LabWeg_o_u(new Level(1, 7)));
    waende.add(new LabWeg_o_u(new Level(1, 8)));
    waende.add(new LabEck_ru(new Level(1, 6)));
    waende.add(new LabEck_lu(new Level(2, 6)));
    waende.add(new LabWeg_O(new Level(3, 6)));
    waende.add(new LabEck_lu(new Level(4, 6)));
    waende.add(new LabWeg_O(new Level(5, 7)));
    waende.add(new LabWeg_O(new Level(6, 7)));
    waende.add(new LabWeg_O(new Level(7, 7)));
    waende.add(new LabWeg_O(new Level(8, 7)));
    waende.add(new LabWeg_O(new Level(9, 7)));
    waende.add(new LabWeg_U(new Level(10, 11)));
    waende.add(new LabWeg_O(new Level(11, 11)));
    waende.add(new LabWeg_O(new Level(11, 10)));
    waende.add(new LabWeg_O(new Level(12, 10)));
    waende.add(new LabWeg_R(new Level(13, 10)));
    waende.add(new LabWeg_o_u(new Level(13, 9)));
    waende.add(new LabWeg_L(new Level(13, 8)));
    waende.add(new LabTuer_R(new Level(13, 8)));
    waende.add(new LabWeg_o_u(new Level(13, 7)));
    waende.add(new LabEck_lu(new Level(13, 6), true));
    waende.add(new LabWeg_r_l(new Level(12, 6)));
    waende.add(new LabWeg_r_l(new Level(11, 6)));
    waende.add(new Sackgasse(new Level(10, 6), "r"));
    waende.add(new LabEck_ru(new Level(10, 5)));
    waende.add(new LabWeg_O(new Level(11, 5)));
    waende.add(new LabWeg_O(new Level(12, 5)));
    waende.add(new LabWeg_O(new Level(13, 5)));
    waende.add(new LabWeg_O(new Level(14, 5)));
    waende.add(new LabWeg_r_l(new Level(15, 5)));
    waende.add(new LabWeg_r_l(new Level(16, 5)));
    waende.add(new LabWeg_r_l(new Level(17, 5)));
    waende.add(new LabEck_lu(new Level(18, 5)));
    waende.add(new LabWeg_o_u(new Level(18, 6)));
    waende.add(new LabWeg_o_u(new Level(18, 7)));
    waende.add(new LabEck_lo(new Level(18, 8)));
    waende.add(new LabWeg_r_l(new Level(17, 8)));
    waende.add(new LabWeg_r_l(new Level(16, 8)));
    waende.add(new LabWeg_r_l(new Level(15, 8)));
    waende.add(new LabWeg_O(new Level(14, 7)));
    waende.add(new LabWeg_O(new Level(15, 7)));
    waende.add(new LabWeg_O(new Level(16, 7)));
    waende.add(new LabWeg_L(new Level(19, 9)));
    waende.add(new LabEck_lu(new Level(19, 10)));
    waende.add(new LabTuer_L(new Level(19, 10)));
    waende.add(new LabWeg_o_u(new Level(19, 11)));
    waende.add(new LabWeg_o_u(new Level(19, 12)));
    waende.add(new Sackgasse(new Level(18, 13), "o"));
    waende.add(new LabWeg_R(new Level(18, 14)));
    waende.add(new LabWeg_O(new Level(14, 10)));
    waende.add(new LabWeg_O(new Level(15, 10)));
    waende.add(new LabWeg_U(new Level(14, 11)));
    waende.add(new Sackgasse(new Level(15, 11), "l"));
    waende.add(new LabEck_ro(new Level(17, 9)));
    waende.add(new LabWeg_R(new Level(18, 10)));
    waende.add(new LabEck_ro(new Level(17, 11)));
    waende.add(new LabWeg_o_u(new Level(17, 12)));
    waende.add(new LabWeg_o_u(new Level(17, 13)));
    waende.add(new LabWeg_o_u(new Level(17, 14)));
    waende.add(new LabEck_lo(new Level(17, 15)));
    waende.add(new LabWeg_O(new Level(15, 13)));
    waende.add(new LabWeg_O(new Level(16, 13)));
    waende.add(new LabEck_ro(new Level(13, 18)));
    waende.add(new LabWeg_U(new Level(14, 18)));
    waende.add(new LabWeg_L(new Level(15, 18)));
    waende.add(new LabWeg_o_u(new Level(15, 17)));
    waende.add(new LabWeg_o_u(new Level(15, 16)));
    waende.add(new LabWeg_o_u(new Level(15, 15)));
    waende.add(new LabWeg_R(new Level(15, 14)));
    waende.add(new LabWeg_O(new Level(14, 14)));
    waende.add(new LabWeg_U(new Level(15, 18)));
    waende.add(new LabWeg_U(new Level(16, 18)));
    waende.add(new LabEck_lo(new Level(17, 18)));
    waende.add(new LabWeg_o_u(new Level(17, 17)));
    waende.add(new LabWeg_R(new Level(17, 16)));
    waende.add(new LabWeg_O(new Level(16, 16)));
    waende.add(new LabWeg_o_u(new Level(19, 15)));
    waende.add(new LabWeg_o_u(new Level(19, 16)));
    waende.add(new LabWeg_o_u(new Level(19, 17)));
    waende.add(new Sackgasse(new Level(19, 18), "u"));
    waende.add(new LabWeg_o_u(new Level(19, 19)));
    waende.add(new LabEck_ru(new Level(18, 20)));
    waende.add(new LabTuer_U(new Level(18, 20)));
    waende.add(new Sackgasse(new Level(16, 20), "u"));
    waende.add(new LabWeg_O(new Level(15, 20)));
    waende.add(new LabTuer_L(new Level(15, 20)));
    waende.add(new LabWeg_r_l(new Level(14, 20)));
    waende.add(new LabWeg_r_l(new Level(13, 20)));
    waende.add(new LabWeg_O(new Level(12, 20)));
    waende.add(new LabWeg_o_u(new Level(11, 19)));
    waende.add(new LabWeg_o_u(new Level(11, 20)));
    waende.add(new LabWeg_o_u(new Level(11, 21)));
    waende.add(new LabWeg_o_u(new Level(11, 22)));
    waende.add(new LabWeg_o_u(new Level(11, 23)));
    waende.add(new LabEck_lo(new Level(11, 24)));
    waende.add(new LabWeg_r_l(new Level(10, 24)));
    waende.add(new LabWeg_r_l(new Level(9, 24)));
    waende.add(new LabEck_ru(new Level(8, 24)));
    waende.add(new LabWeg_L(new Level(8, 25)));
    waende.add(new LabWeg_r_l(new Level(8, 26)));
    waende.add(new LabWeg_r_l(new Level(9, 26)));
    waende.add(new LabWeg_r_l(new Level(10, 26)));
    waende.add(new LabWeg_r_l(new Level(11, 26)));
    waende.add(new LabWeg_r_l(new Level(12, 26)));
    waende.add(new LabWeg_r_l(new Level(13, 26)));
    waende.add(new LabEck_lo(new Level(14, 26)));
    waende.add(new LabWeg_o_u(new Level(14, 25)));
    waende.add(new LabWeg_o_u(new Level(14, 24)));
    waende.add(new LabWeg_o_u(new Level(14, 23)));
    waende.add(new Sackgasse(new Level(14, 22), "u"));
    waende.add(new LabWeg_o_u(new Level(15, 21)));
    waende.add(new LabWeg_o_u(new Level(15, 22)));
    waende.add(new LabEck_ro(new Level(15, 23)));
    waende.add(new LabWeg_R(new Level(16, 21)));
    waende.add(new LabWeg_R(new Level(16, 22)));
    waende.add(new LabWeg_L(new Level(13, 21)));
    waende.add(new LabWeg_L(new Level(13, 22)));
    waende.add(new LabWeg_L(new Level(13, 23)));
    waende.add(new LabWeg_L(new Level(13, 24)));
    waende.add(new LabWeg_U(new Level(7, 27)));
    waende.add(new LabWeg_U(new Level(8, 27)));
    waende.add(new LabWeg_U(new Level(9, 27)));
    waende.add(new LabWeg_U(new Level(10, 27)));
    waende.add(new LabWeg_U(new Level(11, 27)));
    waende.add(new LabWeg_U(new Level(12, 27)));
    waende.add(new LabWeg_U(new Level(13, 27)));
    waende.add(new LabEck_ro(new Level(14, 28)));
    waende.add(new LabEck_ro(new Level(15, 28)));
    waende.add(new LabEck_lo(new Level(16, 28)));
    waende.add(new LabWeg_o_u(new Level(15, 27)));
    waende.add(new LabWeg_R(new Level(15, 26)));
    waende.add(new Sackgasse(new Level(6, 24), "l"));
    waende.add(new LabWeg_r_l(new Level(5, 24)));
    waende.add(new LabWeg_r_l(new Level(4, 24)));
    waende.add(new LabWeg_r_l(new Level(3, 24)));
    waende.add(new LabEck_ru(new Level(2, 24)));
    waende.add(new LabWeg_L(new Level(2, 25)));
    waende.add(new Sackgasse(new Level(6, 26), "l"));
    waende.add(new LabWeg_r_l(new Level(5, 26)));
    waende.add(new LabEck_ru(new Level(4, 26)));
    waende.add(new LabEck_ro(new Level(4, 27)));
    waende.add(new LabWeg_U(new Level(5, 27)));
    waende.add(new LabWeg_R(new Level(6, 27)));
    waende.add(new LabEck_lo(new Level(6, 28)));
    waende.add(new LabWeg_U(new Level(5, 28)));
    waende.add(new LabWeg_U(new Level(4, 28)));
    waende.add(new LabWeg_U(new Level(3, 28)));
    waende.add(new LabWeg_R(new Level(16, 27)));
    waende.add(new LabEck_lu(new Level(11, 8)));
    waende.add(new LabWeg_R(new Level(11, 9)));
    waende.add(new LabWeg_U(new Level(10, 8)));
    waende.add(new LabWeg_L(new Level(10, 7)));
    waende.add(new LabWeg_r_l(new Level(16, 25)));
    waende.add(new LabWeg_r_l(new Level(17, 25)));
    waende.add(new LabWeg_U(new Level(17, 28)));
    waende.add(new LabWeg_L(new Level(18, 24)));
    waende.add(new LabWeg_L(new Level(18, 26)));
    waende.add(new LabWeg_L(new Level(18, 27)));
    waende.add(new LabEck_ro(new Level(18, 28), true));
    waende.add(new LabWeg_U(new Level(16, 23)));
    waende.add(new LabWeg_U(new Level(19, 27)));
    waende.add(new LabEck_lo(new Level(20, 27), true));
    waende.add(new LabWeg_R(new Level(20, 26)));
    waende.add(new LabWeg_r_l(new Level(21, 25)));
    waende.add(new LabEck_lu(new Level(22, 25), true));
    waende.add(new LabWeg_o_u(new Level(22, 26)));
    waende.add(new LabWeg_o_u(new Level(22, 27)));
    waende.add(new LabEck_ro(new Level(22, 28), true));
    waende.add(new LabWeg_U(new Level(21, 28)));
    waende.add(new LabWeg_U(new Level(20, 28)));
    waende.add(new LabWeg_U(new Level(19, 28)));
    waende.add(new LabWeg_U(new Level(23, 28)));
    waende.add(new LabEck_lo(new Level(24, 28), true));
    waende.add(new LabWeg_o_u(new Level(24, 27)));
    waende.add(new LabWeg_o_u(new Level(24, 26)));
    waende.add(new LabEck_ru(new Level(24, 25), true));
    waende.add(new Sackgasse(new Level(25, 25), "l"));
    waende.add(new LabWeg_L(new Level(18, 21)));
    waende.add(new LabEck_ru(new Level(18, 23), true));
    waende.add(new LabWeg_O(new Level(17, 23)));
    waende.add(new LabWeg_O(new Level(19, 23)));
    waende.add(new LabWeg_R(new Level(20, 23)));
    waende.add(new LabWeg_R(new Level(20, 24)));
    waende.add(new LabWeg_o_u(new Level(20, 22)));
    waende.add(new LabEck_ru(new Level(20, 21)));
    waende.add(new LabWeg_O(new Level(21, 21)));
    waende.add(new LabWeg_o_u(new Level(22, 21)));
    waende.add(new LabWeg_o_u(new Level(22, 22)));
    waende.add(new LabWeg_o_u(new Level(22, 23)));
    waende.add(new LabWeg_R(new Level(22, 24)));
    waende.add(new LabWeg_R(new Level(23, 24)));
    waende.add(new LabWeg_R(new Level(23, 23)));
    waende.add(new LabWeg_R(new Level(23, 22)));
    waende.add(new LabWeg_R(new Level(23, 21)));
    waende.add(new LabWeg_R(new Level(23, 20)));
    waende.add(new Sackgasse(new Level(23, 19), "o"));
    waende.add(new LabWeg_o_u(new Level(23, 18)));
    waende.add(new LabWeg_o_u(new Level(23, 17)));
    waende.add(new LabEck_lu(new Level(23, 16)));
    waende.add(new LabWeg_r_l(new Level(22, 16)));
    waende.add(new LabWeg_r_l(new Level(21, 16)));
    waende.add(new LabWeg_r_l(new Level(21, 14)));
    waende.add(new LabWeg_r_l(new Level(22, 14)));
    waende.add(new LabWeg_O(new Level(20, 14)));
    waende.add(new LabEck_lo(new Level(23, 14)));
    waende.add(new LabEck_lu(new Level(23, 13)));
    waende.add(new LabWeg_O(new Level(22, 13)));
    waende.add(new LabWeg_O(new Level(21, 13)));
    waende.add(new LabWeg_O(new Level(20, 13)));
    waende.add(new LabWeg_L(new Level(21, 17)));
    waende.add(new LabWeg_o_u(new Level(21, 18)));
    waende.add(new Sackgasse(new Level(21, 19), "o"));
    waende.add(new LabWeg_O(new Level(19, 21)));
    waende.add(new LabEck_lu(new Level(24, 15)));
    waende.add(new LabWeg_U(new Level(24, 16)));
    waende.add(new LabWeg_r_l(new Level(25, 16)));
    waende.add(new Sackgasse(new Level(26, 16), "l"));
    waende.add(new LabTuer_U(new Level(-5, 21)));
    waende.add(new LabGitter("o", new Level(10, 19)));
    waende.add(new LabGitter("u", new Level(23, 24)));
    waende.add(new LabGitter("l", new Level(15, 5)));
    waende.add(new LabTuer_U(new Level(16, 11)));
    for (int i = 0; i < 10; i++)
    {
      waende.add(new LabWeg_r_l(new Level(-i, 14)));
    }
    
    // Ecksteine
    steine.add(new Eckstein(new Level(2, 18)));
    steine.add(new Eckstein(new Level(2, 16)));
    steine.add(new Eckstein(new Level(3, 13)));
    steine.add(new Eckstein(new Level(4, 13)));
    steine.add(new Eckstein(new Level(-3, 21)));
    steine.add(new Eckstein(new Level(2, 23)));
    steine.add(new Eckstein(new Level(2, 27)));
    steine.add(new Eckstein(new Level(-3, 27)));
    steine.add(new Eckstein(new Level(-4, 24)));
    steine.add(new Eckstein(new Level(6, 20)));
    steine.add(new Eckstein(new Level(6, 23)));
    steine.add(new Eckstein(new Level(17, 16)));
    steine.add(new Eckstein(new Level(18, 22)));
    steine.add(new Eckstein(new Level(18, 26)));
    steine.add(new Eckstein(new Level(18, 23)));
    steine.add(new Eckstein(new Level(20, 23)));
    steine.add(new Eckstein(new Level(22, 20)));
    steine.add(new Eckstein(new Level(19, 20)));
    steine.add(new Eckstein(new Level(24, 15)));
    steine.add(new Eckstein(new Level(24, 16)));
    steine.add(new Eckstein(new Level(25, 16)));
    steine.add(new Eckstein(new Level(20, 13)));
    steine.add(new Eckstein(new Level(3, 10)));
    steine.add(new Eckstein(new Level(3, 7)));
    steine.add(new Eckstein(new Level(5, 7)));
    steine.add(new Eckstein(new Level(19, 15)));
    steine.add(new Eckstein(new Level(2, 16)));
    steine.add(new Eckstein(new Level(17, 23)));
    steine.add(new Eckstein(new Level(18, 25)));
    steine.add(new Eckstein(new Level(21, 25)));
    steine.add(new Eckstein(new Level(1, 21)));
    steine.add(new Eckstein(new Level(11, 24)));
    steine.add(new Eckstein(new Level(12, 13)));
    
    //Deko
    
    steine.add(new DekoKreuz(new Level(6, 13), "ru"));
    steine.add(new DekoSchild(0.35f, -19.7f, 0, -60, 0, 0));
    
    // Tueren
    tueren.add(new Tuer_O("d1", new Level(9, 8)));
    tueren.add(new Tuer_L("d2", new Level(1, 21)));
    tueren.add(new Tuer_L("d21", new Level(1, 28)));
    tueren.add(new Tuer_L("d3", new Level(9, 17)));
    tueren.add(new Tuer_U("d31", new Level(16, 11)));
    tueren.add(new Tuer_U("d4", new Level(-5, 21)));
    tueren.add(new Tuer_L("d5", new Level(15, 20)));
    tueren.add(new Tuer_L("d6", new Level(1, 14)));
    tueren.add(new Tuer_U("dplus", new Level(8, 16)));
    tueren.add(new Tuer_R("dplus", new Level(13, 8)));
    tueren.add(new Tuer_L("dplus", new Level(19, 10)));
    tueren.add(new Tuer_U("dplus", new Level(18, 20)));
    
    // Schalter
    schalter.add(new SchalterFeld("D1", new Level(6, 26))); // chronologisch geordnet
    schalter.add(new SchalterFeld("D2", new Level(12, 9))); // die sich oeffnenden Tueren haben klein-d plus die gleiche
                                                            // Folgeziffer wie dieser Befehl
    schalter.add(new SchalterFeld("D3", new Level(0, 22)));
    schalter.add(new SchalterFeld("D4", new Level(0, 23)));
    schalter.add(new SchalterFeld("D5", new Level(19, 22)));
    schalter.add(new SchalterFeld("D6", new Level(36, 16))); // Der finale Schalter schliesst alle bisher offenen
                                                             // Tueren, oeffnet die Tuer zum Ziel und alle anderen
                                                             // bisher verschlossenen Tueren.
    
  }
  
  @Override
  public void step() // Fuehrt die Grund-Funktionen fuer Objekte aus, indem sie die entsprechende Funktion fuer alle
                     // enthaltenen Objekte ausfuehrt.
  {
    
    for (Lab wand : waende)
    {
      wand.hide_unhide();
      wand.step();
    }
    for (Objekt stein : steine)
      if (!stein.hidden) stein.step();
    for (Lab tuer : tueren)
    {
      tuer.hide_unhide();
      tuer.step();
    }
    for (Objekt schalt : schalter)
      if (!schalt.hidden) schalt.step();
  }
  
  @Override
  public void collision()
  {
    
    for (Objekt wand : waende)
      wand.collision();
    for (Objekt stein : steine)
      if (!stein.hidden) stein.collision();
    for (Objekt tuer : tueren)
      tuer.collision();
    for (Objekt schalt : schalter)
      if (!schalt.hidden) schalt.collision();
  }
  
  @Override
  public void draw()
  {
    
    for (Objekt wand : waende)
      wand.draw();
    for (Objekt stein : steine)
      if (!stein.hidden) stein.draw();
    for (Objekt tuer : tueren)
      tuer.draw();
    for (Objekt schalt : schalter)
      if (!schalt.hidden) schalt.draw();
  }
  
  @Override
  public void drawGUI()
  {
    for (Objekt wand : waende)
      wand.drawGUI();
    for (Objekt stein : steine)
      if (!stein.hidden) stein.drawGUI();
    for (Objekt tuer : tueren)
      tuer.drawGUI();
    for (Objekt schalt : schalter)
      if (!schalt.hidden) schalt.drawGUI();
    
  }
}
