package section;

import basics.Level;
import main.Objekt;
import models3D.DekoKreuz;
import path.*;

public class AbschnittD extends Objekt
{
	protected Objekt[] waende = new Objekt[371];
	protected Objekt[] steine = new Objekt[28];

	  
	
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
		
		waende[35] = new LabDmgWeg_L(new Level(7,12)); //nach betaetigung von Schalter 11 wird dieses Stueck um 90 grad gedreht.
		waende[366] = new LabDmgWeg_R(new Level(7,12)); //nach betaetigung von Schalter 11 wird dieses Stueck um 90 grad gedreht.
		
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
		waende[108] = new LabWeg_O(new Level(10,18));
		waende[109] = new LabEck_lu(new Level(11,18));
		waende[110] = new LabWeg_r_l(new Level(11,16));
		waende[111] = new LabWeg_O(new Level(10,15));
		waende[112] = new LabWeg_O(new Level(11,15));
		waende[113] = new LabWeg_O(new Level(12,15));
		waende[114] = new LabWeg_O(new Level(12,16));
		waende[115] = new LabWeg_o_u(new Level(13,16));
		waende[116] = new LabWeg_o_u(new Level(13,17));
		waende[117] = new LabWeg_o_u(new Level(13,15));
		waende[118] = new LabWeg_R(new Level(13,14));
		waende[119] = new LabWeg_o_u(new Level(13,13));
		waende[120] = new LabWeg_o_u(new Level(13,12));
		waende[121] = new LabEck_lu(new Level(13,11));
		waende[122] = new LabEck_ru(new Level(12,11));
		waende[123] = new LabWeg_L(new Level(12,12));
		waende[124] = new LabWeg_U(new Level(12,13));
		waende[125] = new LabWeg_r_l(new Level(11,13));
		waende[126] = new LabWeg_U(new Level(10,13));
		waende[127] = new LabWeg_R(new Level(9,12));
		waende[128] = new LabWeg_o_u(new Level(9,11));
		waende[129] = new LabWeg_o_u(new Level(9,10));
		waende[130] = new LabWeg_o_u(new Level(9,9));
		waende[131] = new LabWeg_o_u(new Level(9,8));
		waende[132] = new LabTuer_O(new Level(9,8));
		waende[133] = new LabWeg_R(new Level(7,11));
		waende[134] = new LabWeg_r_l(new Level(7,10));
		waende[135] = new LabWeg_r_l(new Level(6,10));
		waende[136] = new LabWeg_r_l(new Level(5,10));
		waende[137] = new LabWeg_r_l(new Level(4,10));
		waende[138] = new LabWeg_r_l(new Level(3,10));
		waende[139] = new LabWeg_U(new Level(2,10));
		waende[140] = new LabEck_lu(new Level(2,9));
		waende[141] = new LabEck_ru(new Level(1,9));
		waende[142] = new LabWeg_L(new Level(1,10));
		waende[143] = new LabWeg_L(new Level(1,11));
		waende[144] = new LabWeg_r_l(new Level(8,8));
		waende[145] = new LabWeg_r_l(new Level(7,8));
		waende[146] = new LabWeg_r_l(new Level(6,8));
		waende[147] = new LabWeg_r_l(new Level(5,8));
		waende[148] = new LabEck_ro(new Level(4,8));
		waende[149] = new LabWeg_L(new Level(4,7));
		waende[150] = new LabWeg_U(new Level(3,7));
		waende[151] = new LabWeg_o_u(new Level(1,7));
		waende[152] = new LabWeg_o_u(new Level(1,8));
		waende[153] = new LabEck_ru(new Level(1,6));
		waende[154] = new LabEck_lu(new Level(2,6));
		waende[155] = new LabWeg_O(new Level(3,6));
		waende[156] = new LabEck_lu(new Level(4,6));
		waende[157] = new LabWeg_O(new Level(5,7));
		waende[158] = new LabWeg_O(new Level(6,7));
		waende[159] = new LabWeg_O(new Level(7,7));
		waende[160] = new LabWeg_O(new Level(8,7));
		waende[161] = new LabWeg_O(new Level(9,7));
		waende[162] = new LabWeg_U(new Level(10,11));
		waende[163] = new LabWeg_O(new Level(11,11));
		waende[164] = new LabWeg_O(new Level(11,10));
		waende[165] = new LabWeg_O(new Level(12,10));
		waende[166] = new LabWeg_R(new Level(13,10));
		waende[167] = new LabWeg_o_u(new Level(13,9));
		waende[168] = new LabWeg_o_u(new Level(13,8));
		waende[169] = new LabWeg_o_u(new Level(13,7));
		waende[170] = new LabEck_lu(new Level(13,6),true);
		waende[171] = new LabWeg_r_l(new Level(12,6));
		waende[172] = new LabWeg_r_l(new Level(11,6));
		waende[173] = new Sackgasse(new Level(10,6),"r");
		waende[174] = new LabEck_ru(new Level(10,5));
		waende[175] = new LabWeg_O(new Level(11,5));
		waende[176] = new LabWeg_O(new Level(12,5));
		waende[177] = new LabWeg_O(new Level(13,5));
		waende[178] = new LabWeg_O(new Level(14,5));
		waende[179] = new LabWeg_r_l(new Level(15,5));
		waende[180] = new LabWeg_r_l(new Level(16,5));
		waende[181] = new LabWeg_r_l(new Level(17,5));
		waende[182] = new LabEck_lu(new Level(18,5));
		waende[183] = new LabWeg_o_u(new Level(18,6));
		waende[184] = new LabWeg_o_u(new Level(18,7));
		waende[185] = new LabEck_lo(new Level(18,8));
		waende[186] = new LabWeg_r_l(new Level(17,8));
		waende[187] = new LabWeg_r_l(new Level(16,8));
		waende[188] = new LabWeg_r_l(new Level(15,8));
		waende[189] = new LabWeg_O(new Level(14,7));
		waende[190] = new LabWeg_O(new Level(15,7));
		waende[191] = new LabWeg_O(new Level(16,7));
		waende[192] = new LabWeg_L(new Level(19,9));
		waende[193] = new Sackgasse(new Level(19,10),"u");
		waende[194] = new LabWeg_o_u(new Level(19,11));
		waende[195] = new LabWeg_o_u(new Level(19,12));
		waende[196] = new Sackgasse(new Level(18,13),"o");
		waende[197] = new LabWeg_R(new Level(18,14));
		waende[198] = new LabWeg_O(new Level(14,10));
		waende[199] = new LabWeg_O(new Level(15,10));
		waende[200] = new LabWeg_U(new Level(14,11));
		waende[201] = new Sackgasse(new Level(15,11),"l");
		waende[202] = new LabEck_ro(new Level(17,9));
		waende[203] = new LabWeg_R(new Level(18,10));
		waende[204] = new LabEck_ro(new Level(17,11));
		waende[205] = new LabWeg_o_u(new Level(17,12));
		waende[206] = new LabWeg_o_u(new Level(17,13));
		waende[207] = new LabWeg_o_u(new Level(17,14));
		waende[208] = new LabEck_lo(new Level(17,15));
		waende[209] = new LabWeg_O(new Level(15,13));
		waende[210] = new LabWeg_O(new Level(16,13));
		waende[211] = new LabEck_ro(new Level(13,18));
		waende[212] = new LabWeg_U(new Level(14,18));
		waende[213] = new LabWeg_L(new Level(15,18));
		waende[214] = new LabWeg_o_u(new Level(15,17));
		waende[215] = new LabWeg_o_u(new Level(15,16));
		waende[216] = new LabWeg_o_u(new Level(15,15));
		waende[217] = new LabWeg_R(new Level(15,14));
		waende[218] = new LabWeg_O(new Level(14,14));
		waende[219] = new LabWeg_U(new Level(15,18));
		waende[220] = new LabWeg_U(new Level(16,18));
		waende[221] = new LabWeg_U(new Level(17,18));
		waende[222] = new LabWeg_o_u(new Level(17,17));
		waende[223] = new LabWeg_R(new Level(17,16));
		waende[224] = new LabWeg_O(new Level(16,16));
		waende[225] = new LabWeg_o_u(new Level(19,15));
		waende[226] = new LabWeg_o_u(new Level(19,16));
		waende[227] = new LabWeg_o_u(new Level(19,17));
		waende[228] = new Sackgasse(new Level(19,18),"u");
		waende[229] = new LabWeg_o_u(new Level(19,19));
		waende[230] = new Sackgasse(new Level(18,20),"r");
		waende[231] = new Sackgasse(new Level(16,20),"u");
		waende[232] = new LabWeg_O(new Level(15,20));
		waende[233] = new LabTuer_L(new Level(15,20));
		waende[234] = new LabWeg_r_l(new Level(14,20));
		waende[235] = new LabWeg_r_l(new Level(13,20));
		waende[236] = new LabWeg_O(new Level(12,20));
		waende[237] = new LabWeg_o_u(new Level(11,19));
		waende[238] = new LabWeg_o_u(new Level(11,20));
		waende[239] = new LabWeg_o_u(new Level(11,21));
		waende[240] = new LabWeg_o_u(new Level(11,22));
		waende[241] = new LabWeg_o_u(new Level(11,23));
		waende[242] = new LabEck_lo(new Level(11,24));
		waende[243] = new LabWeg_r_l(new Level(10,24));
		waende[244] = new LabWeg_r_l(new Level(9,24));
		waende[245] = new LabEck_ru(new Level(8,24));
		waende[246] = new LabWeg_L(new Level(8,25));
		waende[247] = new LabWeg_r_l(new Level(8,26));
		waende[248] = new LabWeg_r_l(new Level(9,26));
		waende[249] = new LabWeg_r_l(new Level(10,26));
		waende[250] = new LabWeg_r_l(new Level(11,26));
		waende[251] = new LabWeg_r_l(new Level(12,26));
		waende[252] = new LabWeg_r_l(new Level(13,26));
		waende[253] = new LabEck_lo(new Level(14,26));
		waende[254] = new LabWeg_o_u(new Level(14,25));
		waende[255] = new LabWeg_o_u(new Level(14,24));
		waende[256] = new LabWeg_o_u(new Level(14,23));
		waende[257] = new Sackgasse(new Level(14,22),"u");
		waende[258] = new LabWeg_o_u(new Level(15,21));
		waende[259] = new LabWeg_o_u(new Level(15,22));
		waende[260] = new LabEck_ro(new Level(15,23));
		waende[261] = new LabWeg_R(new Level(16,21));
		waende[262] = new LabWeg_R(new Level(16,22));
		waende[263] = new LabWeg_L(new Level(13,21));
		waende[264] = new LabWeg_L(new Level(13,22));
		waende[265] = new LabWeg_L(new Level(13,23));
		waende[266] = new LabWeg_L(new Level(13,24));
		waende[267] = new LabWeg_U(new Level(7,27));
		waende[268] = new LabWeg_U(new Level(8,27));
		waende[269] = new LabWeg_U(new Level(9,27));
		waende[270] = new LabWeg_U(new Level(10,27));
		waende[271] = new LabWeg_U(new Level(11,27));
		waende[272] = new LabWeg_U(new Level(12,27));
		waende[273] = new LabWeg_U(new Level(13,27));
		waende[274] = new LabEck_ro(new Level(14,28));
		waende[275] = new LabEck_ro(new Level(15,28));
		waende[276] = new LabEck_lo(new Level(16,28));
		waende[277] = new LabWeg_o_u(new Level(15,27));
		waende[278] = new LabWeg_R(new Level(15,26));
		waende[279] = new Sackgasse(new Level(6,24),"l");
		waende[280] = new LabWeg_r_l(new Level(5,24));
		waende[281] = new LabWeg_r_l(new Level(4,24));
		waende[282] = new LabWeg_r_l(new Level(3,24));
		waende[283] = new LabEck_ru(new Level(2,24));
		waende[284] = new LabWeg_L(new Level(2,25));
		waende[285] = new Sackgasse(new Level(6,26),"l");
		waende[286] = new LabWeg_r_l(new Level(5,26));
		waende[287] = new LabEck_ru(new Level(4,26));
		waende[288] = new LabEck_ro(new Level(4,27));
		waende[289] = new LabWeg_U(new Level(5,27));
		waende[290] = new LabWeg_R(new Level(6,27));
		waende[291] = new LabEck_lo(new Level(6,28));
		waende[292] = new LabWeg_U(new Level(5,28));
		waende[293] = new LabWeg_U(new Level(4,28));
		waende[294] = new LabWeg_U(new Level(3,28));
		waende[295] = new LabWeg_R(new Level(16,27));
		waende[296] = new LabEck_lu(new Level(11,8));
		waende[297] = new LabWeg_R(new Level(11,9));
		waende[298] = new LabWeg_U(new Level(10,8));
		waende[299] = new LabWeg_L(new Level(10,7));
		waende[300] = new LabWeg_r_l(new Level(16,25));
		waende[301] = new LabWeg_r_l(new Level(17,25));
		waende[302] = new LabWeg_U(new Level(17,28));
		waende[303] = new LabWeg_L(new Level(18,24));
		waende[304] = new LabWeg_L(new Level(18,26));
		waende[305] = new LabWeg_L(new Level(18,27));
		waende[306] = new LabEck_ro(new Level(18,28),true);
		waende[307] = new LabWeg_U(new Level(16,23));
		waende[308] = new LabWeg_U(new Level(19,27));
		waende[309] = new LabEck_lo(new Level(20,27),true);
		waende[310] = new LabWeg_R(new Level(20,26));
		waende[311] = new LabWeg_r_l(new Level(21,25));
		waende[312] = new LabEck_lu(new Level(22,25),true);
		waende[313] = new LabWeg_o_u(new Level(22,26));
		waende[314] = new LabWeg_o_u(new Level(22,27));
		waende[315] = new LabEck_ro(new Level(22,28),true);
		waende[316] = new LabWeg_U(new Level(21,28));
		waende[317] = new LabWeg_U(new Level(20,28));
		waende[318] = new LabWeg_U(new Level(19,28));
		waende[319] = new LabWeg_U(new Level(23,28));
		waende[320] = new LabEck_lo(new Level(24,28),true);
		waende[321] = new LabWeg_o_u(new Level(24,27));
		waende[322] = new LabWeg_o_u(new Level(24,26));
		waende[323] = new LabEck_ru(new Level(24,25),true);
		waende[324] = new Sackgasse(new Level(25,25),"l");
		waende[325] = new LabWeg_L(new Level(18,21));
		waende[326] = new LabEck_ru(new Level(18,23),true);
		waende[327] = new LabWeg_O(new Level(17,23));
		waende[328] = new LabWeg_O(new Level(19,23));
		waende[329] = new LabWeg_R(new Level(20,23));
		waende[330] = new LabWeg_R(new Level(20,24));
		waende[331] = new LabWeg_o_u(new Level(20,22));
		waende[332] = new LabEck_ru(new Level(20,21));
		waende[333] = new LabWeg_O(new Level(21,21));
		waende[334] = new LabWeg_o_u(new Level(22,21));
		waende[335] = new LabWeg_o_u(new Level(22,22));
		waende[336] = new LabWeg_o_u(new Level(22,23));
		waende[337] = new LabWeg_R(new Level(22,24));
		waende[338] = new LabWeg_R(new Level(23,24));
		waende[339] = new LabWeg_R(new Level(23,23));
		waende[340] = new LabWeg_R(new Level(23,22));
		waende[341] = new LabWeg_R(new Level(23,21));
		waende[342] = new LabWeg_R(new Level(23,20));
		waende[343] = new Sackgasse(new Level(23,19),"o");
		waende[344] = new LabWeg_o_u(new Level(23,18));
		waende[345] = new LabWeg_o_u(new Level(23,17));
		waende[346] = new LabEck_lu(new Level(23,16));
		waende[347] = new LabWeg_r_l(new Level(22,16));
		waende[348] = new LabWeg_r_l(new Level(21,16));
		waende[349] = new LabWeg_r_l(new Level(21,14));
		waende[350] = new LabWeg_r_l(new Level(22,14));
		waende[351] = new LabWeg_O(new Level(20,14));
		waende[352] = new LabEck_lo(new Level(23,14));
		waende[353] = new LabEck_lu(new Level(23,13));
		waende[354] = new LabWeg_O(new Level(22,13));
		waende[355] = new LabWeg_O(new Level(21,13));
		waende[356] = new LabWeg_O(new Level(20,13));
		waende[357] = new LabWeg_L(new Level(21,17));
		waende[358] = new LabWeg_o_u(new Level(21,18));
		waende[359] = new Sackgasse(new Level(21,19),"o");
		waende[360] = new LabWeg_O(new Level(19,21));
		waende[361] = new LabEck_lu(new Level(24,15));
		waende[362] = new LabWeg_U(new Level(24,16));
		waende[363] = new LabWeg_r_l(new Level(25,16));
		waende[364] = new LabWeg_r_l(new Level(26,16));
		waende[365] = new LabTuer_U(new Level(-5,21));
		waende[367] = new LabGitter("o",new Level(10,19));
		waende[368] = new LabGitter("u", new Level(23,24));
		waende[369] = new LabGitter("l", new Level(15,5));
		waende[370] = new LabTuer_U(new Level(16,11));
		
		
		
		//Ecksteine
		steine[0] = new Eckstein(new Level(2,18));
		steine[1] = new Eckstein(new Level(2,16));
		steine[2] = new Eckstein(new Level(3,13));
		steine[3] = new Eckstein(new Level(4,13));
		steine[4] = new Eckstein(new Level(-3,21));
		steine[5] = new Eckstein(new Level(2,23));
		steine[6] = new Eckstein(new Level(2,27));
		steine[7] = new Eckstein(new Level(-3,27));
		steine[8] = new Eckstein(new Level(-4,24));
		steine[9] = new Eckstein(new Level(6,20));
		steine[10] = new Eckstein(new Level(6,23));
		steine[11] = new Eckstein(new Level(17,16));
		steine[12] = new Eckstein(new Level(18,22));
		steine[13] = new Eckstein(new Level(18,26));
		steine[14] = new Eckstein(new Level(18,23));
		steine[15] = new Eckstein(new Level(20,23));
		steine[16] = new Eckstein(new Level(22,20));
		steine[17] = new Eckstein(new Level(19,20));
		steine[18] = new Eckstein(new Level(24,15));
		steine[19] = new Eckstein(new Level(24,16));
		steine[20] = new Eckstein(new Level(25,16));
		steine[21] = new Eckstein(new Level(20,13));
		steine[22] = new Eckstein(new Level(3,10));
		steine[23] = new Eckstein(new Level(3,7));
		steine[24] = new Eckstein(new Level(5,7));
		steine[25] = new Eckstein(new Level(19,15));
		steine[26] = new DekoKreuz(new Level(6,13),"ru");
		steine[27] = new Eckstein(new Level(2,16));
		
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
