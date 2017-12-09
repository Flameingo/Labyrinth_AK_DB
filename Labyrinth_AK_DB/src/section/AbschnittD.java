package section;

import basics.Level;
import main.Objekt;
import models3D.RundeTreppe;
import params.Material;
import path.*;

public class AbschnittD extends Objekt
{
	protected Objekt[] waende = new Objekt[189];
	protected Objekt[] steine = new Objekt[0];
	  
	
	public AbschnittD()
	{
		waende[0] = new LabEck_ru(new Level(-5,21));
		waende[1] = new LabWeg_r_l(new Level(-4,21));
		waende[2] = new LabEck_lo(new Level(-3,21));
		waende[3] = new LabEck_ru(new Level(-3,20));
		waende[4] = new LabEck_lu(new Level(-2,20));
		waende[5] = new LabEck_ro(new Level(-2,21));
		waende[6] = new LabWeg_r_l(new Level(-1,21));
		waende[7] = new LabWeg_r_l(new Level(0,21));
		waende[8] = new LabWeg_L(new Level(-5,22));
		waende[9] = new LabWeg_r_l(new Level(0,23));
		waende[10] = new LabWeg_r_l(new Level(-1,23));
		waende[11] = new LabWeg_r_l(new Level(-2,23));
		waende[12] = new LabWeg_r_l(new Level(-3,23));
		waende[13] = new LabWeg_r_l(new Level(-4,23));
		waende[14] = new LabEck_ru(new Level(-5,23),true);
		waende[15] = new LabWeg_o_u(new Level(-5,24));
		waende[16] = new LabWeg_o_u(new Level(-5,25));
		waende[17] = new LabWeg_o_u(new Level(-5,26));
		waende[18] = new LabWeg_o_u(new Level(-5,27));
		waende[19] = new LabEck_ro(new Level(-5,28),true);
		waende[20] = new LabWeg_U(new Level(-4,28));
		waende[21] = new LabWeg_U(new Level(-3,28));
		waende[22] = new LabWeg_U(new Level(-2,28));
		waende[23] = new LabWeg_U(new Level(-1,28));
		waende[24] = new LabWeg_U(new Level(0,28));
		waende[25] = new LabWeg_r_l(new Level(-3,27));
		waende[26] = new LabWeg_r_l(new Level(-2,27));
		waende[27] = new LabWeg_r_l(new Level(-1,27));
		waende[28] = new LabWeg_U(new Level(0,27));
		waende[29] = new LabWeg_R(new Level(-4,26));
		waende[30] = new LabWeg_R(new Level(-4,25));
		waende[31] = new LabWeg_O(new Level(-3,25));
		waende[32] = new LabWeg_r_l(new Level(-2,25));
		waende[33] = new LabWeg_r_l(new Level(-1,25));
		waende[34] = new LabWeg_U(new Level(0,25));
		waende[35] = new LabWeg_o_u(new Level(7,12)); //nach betaetigung von Schalter 11 wird dieses Stueck zu LabWeg_r_l geaendert.
		waende[36] = new LabWeg_r_l(new Level(1,28));
		waende[37] = new LabEck_lo(new Level(2,28));
		waende[38] = new LabEck_lu(new Level(2,27));
		waende[39] = new LabWeg_L(new Level(1,27));
		waende[40] = new LabWeg_o_u(new Level(1,26));
		waende[41] = new LabWeg_o_u(new Level(1,25));
		waende[42] = new LabWeg_o_u(new Level(1,24));
		waende[43] = new LabWeg_o_u(new Level(1,23));
		waende[44] = new LabEck_ru(new Level(1,22),true);
		waende[45] = new LabWeg_r_l(new Level(2,22));
		waende[46] = new LabWeg_r_l(new Level(3,22));
		waende[47] = new LabWeg_r_l(new Level(4,22));
		waende[48] = new LabEck_lo(new Level(5,22),true);
		waende[49] = new LabWeg_R(new Level(5,21));
		waende[50] = new LabEck_lu(new Level(5,20),true);
		waende[51] = new LabWeg_r_l(new Level(4,20));
		waende[52] = new LabWeg_r_l(new Level(3,20));
		waende[53] = new LabWeg_r_l(new Level(2,20));
		waende[54] = new LabEck_ro(new Level(1,20));
		waende[55] = new LabTuer_L(new Level(1,21));
		waende[56] = new LabTuer_L(new Level(1,28));
		waende[57] = new LabWeg_L(new Level(1,19));
		waende[58] = new LabEck_ro(new Level(1,18),true);
		waende[59] = new LabWeg_r_l(new Level(2,18));
		waende[60] = new LabWeg_r_l(new Level(3,18));
		waende[61] = new LabWeg_R(new Level(5,19));
		waende[62] = new LabWeg_o_u(new Level(5,18));
		waende[63] = new LabWeg_o_u(new Level(5,17));
		waende[64] = new LabWeg_o_u(new Level(5,16));
		waende[65] = new LabWeg_o_u(new Level(1,17));
		waende[66] = new LabWeg_o_u(new Level(1,16));
		waende[67] = new LabEck_ru(new Level(1,15),true);
		waende[68] = new LabWeg_r_l(new Level(2,15));
		waende[69] = new LabWeg_U(new Level(3,16));
		waende[70] = new LabWeg_U(new Level(4,16));
		waende[71] = new LabEck_lo(new Level(3,15),true);
		waende[72] = new LabWeg_R(new Level(3,14));
		waende[73] = new LabWeg_R(new Level(3,13));
		waende[74] = new LabWeg_r_l(new Level(2,13));
		waende[75] = new LabEck_ro(new Level(1,13));
		waende[76] = new LabEck_ru(new Level(1,12));
		waende[77] = new LabEck_ru(new Level(3,12));
		waende[78] = new LabWeg_r_l(new Level(4,12));
		waende[79] = new LabWeg_r_l(new Level(5,12));
		waende[80] = new LabWeg_O(new Level(6,12));
		waende[81] = new LabEck_ro(new Level(6,13));
		waende[82] = new LabWeg_o_u(new Level(7,13));
		waende[83] = new LabWeg_L(new Level(5,14));
		waende[84] = new LabEck_ru(new Level(5,15));
		waende[85] = new LabWeg_O(new Level(6,15));
		waende[86] = new LabEck_lu(new Level(7,15));
		waende[87] = new LabWeg_o_u(new Level(7,16));
		waende[88] = new LabWeg_o_u(new Level(7,17));
		waende[89] = new LabWeg_o_u(new Level(7,18));
		waende[90] = new LabWeg_o_u(new Level(7,19));
		waende[91] = new LabWeg_o_u(new Level(7,20));
		waende[92] = new LabWeg_o_u(new Level(7,21));
		waende[93] = new LabEck_ro(new Level(7,22),true);
		waende[94] = new LabWeg_U(new Level(8,22));
		waende[95] = new LabEck_lo(new Level(9,22),true);
		waende[96] = new LabWeg_o_u(new Level(9,21));
		waende[97] = new LabWeg_o_u(new Level(9,20));
		waende[98] = new LabWeg_o_u(new Level(9,19));
		waende[99] = new LabEck_ru(new Level(9,18));
		waende[100] = new LabTuer_L(new Level(9,17));
		waende[101] = new LabEck_ro(new Level(9,16));
		waende[102] = new LabWeg_U(new Level(8,16));
		waende[103] = new LabEck_ru(new Level(9,15));
		waende[104] = new LabWeg_R(new Level(7,14));
		waende[105] = new LabWeg_o_u(new Level(9,13));
		waende[106] = new LabWeg_r_l(new Level(8,12));
		waende[107] = new LabWeg_r_l(new Level(10,16));
		waende[108] = new LabWeg_r_l(new Level(10,18));
		waende[109] = new LabEck_lu(new Level(11,18));
		waende[110] = new LabWeg_r_l(new Level(11,16));
		waende[101] = new LabWeg_O(new Level(10,15));
		waende[102] = new LabWeg_O(new Level(11,15));
		waende[103] = new LabWeg_O(new Level(12,15));
		waende[104] = new LabWeg_O(new Level(12,16));
		waende[105] = new LabWeg_o_u(new Level(13,16));
		waende[106] = new LabWeg_o_u(new Level(13,17));
		waende[107] = new LabWeg_o_u(new Level(13,15));
		waende[108] = new LabWeg_R(new Level(13,14));
		waende[109] = new LabWeg_o_u(new Level(13,13));
		waende[110] = new LabWeg_o_u(new Level(13,12));
		waende[111] = new LabEck_lu(new Level(13,11));
		waende[112] = new LabEck_ru(new Level(12,11));
		waende[113] = new LabWeg_L(new Level(12,12));
		waende[114] = new LabWeg_U(new Level(12,13));
		waende[115] = new LabWeg_r_l(new Level(11,13));
		waende[116] = new LabWeg_U(new Level(10,13));
		waende[117] = new LabWeg_R(new Level(9,12));
		waende[118] = new LabWeg_o_u(new Level(9,11));
		waende[119] = new LabWeg_o_u(new Level(9,10));
		waende[120] = new LabWeg_o_u(new Level(9,9));
		waende[121] = new LabWeg_o_u(new Level(9,8));
		waende[122] = new LabTuer_O(new Level(9,8));
		waende[123] = new LabWeg_R(new Level(7,11));
		waende[124] = new LabWeg_r_l(new Level(7,10));
		waende[125] = new LabWeg_r_l(new Level(6,10));
		waende[126] = new LabWeg_r_l(new Level(5,10));
		waende[127] = new LabWeg_r_l(new Level(4,10));
		waende[128] = new LabWeg_r_l(new Level(3,10));
		waende[129] = new LabWeg_U(new Level(2,10));
		waende[130] = new LabEck_lu(new Level(2,9));
		waende[131] = new LabEck_ru(new Level(1,9));
		waende[132] = new LabWeg_R(new Level(1,10));
		waende[133] = new LabWeg_R(new Level(1,11));
		waende[134] = new LabWeg_r_l(new Level(8,8));
		waende[135] = new LabWeg_r_l(new Level(7,8));
		waende[136] = new LabWeg_r_l(new Level(6,8));
		waende[137] = new LabWeg_r_l(new Level(5,8));
		waende[138] = new LabEck_ro(new Level(4,8));
		waende[139] = new LabWeg_L(new Level(4,7));
		waende[140] = new LabWeg_U(new Level(3,7));
		waende[141] = new LabWeg_o_u(new Level(1,7));
		waende[142] = new LabWeg_o_u(new Level(1,8));
		waende[143] = new LabEck_ru(new Level(1,6));
		waende[144] = new LabEck_lu(new Level(2,6));
		waende[145] = new LabWeg_O(new Level(3,6));
		waende[146] = new LabEck_lu(new Level(4,6));
		waende[147] = new LabWeg_O(new Level(5,7));
		waende[148] = new LabWeg_O(new Level(6,7));
		waende[149] = new LabWeg_O(new Level(7,7));
		waende[150] = new LabWeg_O(new Level(8,7));
		waende[151] = new LabWeg_O(new Level(9,7));
		waende[152] = new LabWeg_U(new Level(10,11));
		waende[153] = new LabWeg_O(new Level(11,11));
		waende[154] = new LabWeg_O(new Level(11,10));
		waende[155] = new LabWeg_O(new Level(12,10));
		waende[156] = new LabWeg_R(new Level(13,10));
		waende[157] = new LabWeg_o_u(new Level(13,9));
		waende[158] = new LabWeg_o_u(new Level(13,8));
		waende[159] = new LabWeg_o_u(new Level(13,7));
		waende[160] = new LabEck_lu(new Level(13,6),true);
		waende[161] = new LabWeg_r_l(new Level(12,6));
		waende[162] = new LabWeg_r_l(new Level(11,6));
		waende[163] = new Sackgasse(new Level(10,6),"r");
		waende[164] = new LabEck_ru(new Level(10,5));
		waende[165] = new LabWeg_O(new Level(11,5));
		waende[166] = new LabWeg_O(new Level(12,5));
		waende[167] = new LabWeg_O(new Level(13,5));
		waende[168] = new LabWeg_O(new Level(14,5));
		waende[169] = new Sackgasse(new Level(15,5),"r");
		waende[170] = new LabWeg_r_l(new Level(16,5));
		waende[171] = new LabWeg_r_l(new Level(17,5));
		waende[172] = new LabEck_lu(new Level(18,5));
		waende[173] = new LabWeg_o_u(new Level(18,6));
		waende[174] = new LabWeg_o_u(new Level(18,7));
		waende[175] = new LabEck_lo(new Level(18,8));
		waende[176] = new LabWeg_r_l(new Level(17,8));
		waende[177] = new LabWeg_r_l(new Level(16,8));
		waende[178] = new LabWeg_r_l(new Level(15,8));
		waende[179] = new LabWeg_O(new Level(14,7));
		waende[180] = new LabWeg_O(new Level(15,7));
		waende[181] = new LabWeg_O(new Level(16,7));
		waende[182] = new LabWeg_L(new Level(19,9));
		waende[183] = new Sackgasse(new Level(19,10),"u");
		waende[184] = new LabWeg_o_u(new Level(19,11));
		waende[185] = new LabWeg_o_u(new Level(19,12));
		waende[186] = new LabWeg_o_u(new Level(18,13));
		waende[187] = new LabWeg_R(new Level(18,14));
		
	
	}
	@Override
	public void step()
	{
		
		  for (Objekt wand : waende)
		      wand.step();
		    for (Objekt stein : steine)
		      stein.step();	
	}

	@Override
	public void collision()
	{
		
		 for (Objekt wand : waende)
		      wand.collision();
		    for (Objekt stein : steine)
		      stein.collision();
	}

	@Override
	public void draw() 
	{
		
	    for (Objekt wand : waende)
	        wand.draw();
	      for (Objekt stein : steine)
	        stein.draw();	
	}

	@Override
	public void drawGUI() 
	{
		for (Objekt wand : waende)
		      wand.drawGUI();
		    for (Objekt stein : steine)
		      stein.drawGUI();
		
	}

}
