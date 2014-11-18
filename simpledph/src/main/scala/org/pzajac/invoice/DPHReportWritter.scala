package org.pzajac.invoice

/**
 * Generate document according to 
http://adisepo.mfcr.cz/adistc/adis/idpr_pub/epo2_info/popis_struktury_detail.faces?zkratka=DPHDP3 
 *  
 */
 class DPHReportWritter (report: DphReport) {
     
  /**
   * ř. 21
   * Vyplňte podle údajů z daňové evidence
   *  – uvede se údaj o hodnotě plnění při poskytnutí služeb s místem plnění v jiném členském státě podle § 9 odst. 
   *  1, s výjimkou poskytnutí služby, které je v jiném členském státě osvobozeno do daně, osobě registrované k dani v jiném členském státě,
   *   pokud je povinen přiznat a zaplatit daň příjemce služby.
   *   Hodnota plnění z řádku 21 se uvede v souhrnném hlášení s kódem 3. Pokud jde o identifikovanou osobu, 
   *   které nevznikne podle § 101 odst. 6 povinnost podat přiznání, má přesto povinnost podat souhrnné hlášení.
   */
     val pln_sluzby="100000"

     /**
      * ř. 46 - V plné výši
      *– je součtovým řádkem, ve kterém se uvede součet řádků 40 až 45 ve sloupci „V plné výši“ a řádků 40 až 45 ve sloupci „Krácený odpočet“
      */
     val odp_sum_nar="182"
     /**
      * ř. 40 - Krácený odpočet
      * Vyplňte podle údajů z daňové evidence
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění 
      * nebo v úplatě poskytnuté před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení.
      *  Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8 
      *  s kladným znaménkem.
      */
     val odp_tuz23="0"
     /**
      * ř. 40 - V plné výši
      * Vyplňte podle údajů z daňové evidence
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění nebo v úplatě poskytnuté 
      * před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení. 
      * Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8 
      * s kladným znaménkem.
      */
     val odp_tuz23_nar="182"
     /**
      * ř. 41 - Krácený odpočet
      * Vyplňte podle údajů z daňové evidence
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění nebo v úplatě 
      * poskytnuté před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení.
      *  Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8 
      *  s kladným znaménkem.
      *  
      */
     val odp_tuz5="0"
     /**
      * . 41 - V plné výši
      * Vyplňte podle údajů z daňové evidence
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění nebo v úplatě 
      * poskytnuté před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení. 
      * Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8
      *  s kladným znaménkem.
      */
     val odp_tuz5_nar="0"
     /**
      * ř. 40 - Základ daně
      * Vyplňte podle údajů z daňové evidence
      * 
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění nebo v úplatě 
      * poskytnuté před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení.
      *  Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8
      *   s kladným znaménkem.
      */
     val pln23="865"
     /**
      * ř. 41 - Základ daně
      * Vyplňte podle údajů z daňové evidence 
      * – uvede se údaj o základu daně a dani na vstupu, která je obsažena v částce za přijatá zdanitelná plnění nebo v úplatě 
      * poskytnuté před uskutečněním zdanitelného plnění, vznikla-li jejím přijetím povinnost přiznat a zaplatit daň.
      * – uvede se oprava odpočtu daně dle § 74.
      * - dlužník uvede podle § 44 odst. 5 se záporným znaménkem opravu výše daně u pohledávek za dlužníky v insolvenčním řízení.
      *  Neopravuje základ daně, protože předmětné zdanitelné plnění bylo uskutečněno. V případě postupu podle § 44 odst. 6, 7 nebo 8
      *   s kladným znaménkem.
      */
     val pln5="0"
     /**
      * Koeficient(%)
      * Vyplňte podle údajů z daňové evidence
      * – ve sloupci „Koeficient (%)“ se uvede koeficient vypočtený z údajů za zdaňovací období předcházejícího kalendářního roku 
      * (v procentním vyjádření) při vypořádání odpočtu daně podle § 76 odst. 6.
      * - pouze za zdaňovací období leden až březen, resp. 1. čtvrtletí 2011 jako desetinné číslo (0 až 0,94 nebo 1). 
      */
     val koef_p20_nov="100.00" 
     /**
      * ř. 65
      * Je rozdílovým řádkem odpočtu daně a daně na výstupu (ř.63 - ř.62) v případě, že odpočet daně převyšuje daň na výstupu.
      *  Tato hodnota musí obsahovat kladné číslo.   
      */
     val dano_no="182"
     
     
     val odp_zocelk="182"

     
     def vetaD = <VetaD 
			dapdph_forma="B"
 			dokument="DP3"
 			k_uladis="DPH"
 			c_okec="620200"
      ctvrt="1"
 			d_poddp="19.10.2014"
 			rok="2014"
 			trans="A"
 			typ_platce="P" />
     
    def vetaP =  <VetaP c_telef="702549887"
		  c_ufo="463"
 		  c_pracufo="3201"
 		  c_orient="10"
      c_pop="815"
      dic="7604304983"
      email="petr.zajac@gmail.com" 
      jmeno="Petr" 
      naz_obce="Vratimov" 
      prijmeni="Zajac" 
      psc="73932" 
      stat="Česká republika" 
      titul="Ing."
      typ_ds="F"
     ulice="Výletní"
/>
   def veta1 = <Veta1 
			dan23="0"
 			dan5="0"
 			dan_dzb23="0"
 			dan_dzb5="0"
      dan_pdop_nrg="0"
 			dan_psl23_e="0"
 			dan_psl23_z="0"
 			dan_psl5_e="0"
      dan_psl5_z="0"
 			dan_pzb23="0"
 			dan_pzb5="0"
 			dov_zb23="0"
 			dov_zb5="0"
      obrat23="0"
 			obrat5="0"
 			p_dop_nrg="0" 
			p_sl23_e="0"
 			p_sl23_z="0"
 			p_sl5_e="0"
 			p_sl5_z="0"
 			p_zb23="0"
 			p_zb5="0" />
   def veta2 = <Veta2 dod_dop_nrg="0"
 			dod_zb="0"
 			pln_sluzby={pln_sluzby}
 			pln_vyvoz="0"
 			pln_zaslani="0"
 />
  def veta3 = <Veta3
 			tri_dozb="0"
 			tri_pozb="0" />
  def veta4 =  <Veta4
 			dov_cu="0"
 			nar_maj="0"
 			nar_zdp23="0"
 			nar_zdp5="0"
 			od_maj="0"
      od_zdp23="0"
 			od_zdp5="0"
 			odkr_maj="0"
 			odkr_zdp23="0"
 			odkr_zdp5="0"
 			odp_cu="0"
 			odp_cu_nar="0"
 			odp_rez_nar="0"
 			odp_rezim="0"
 			odp_sum_kr="0"
 			odp_sum_nar={odp_sum_nar}
 			odp_tuz23={odp_tuz23}
 			odp_tuz23_nar={odp_tuz23_nar}
 			odp_tuz5={odp_tuz5}
 			odp_tuz5_nar={odp_tuz5_nar}
 			pln23={pln23}
 			pln5={pln5} />
   def veta5 = <Veta5 koef_p20_nov={koef_p20_nov} 
			odp_uprav_kf="0" 
			pln_nkf="0"
      plnosv_kf="0" 
			plnosv_nkf="0" />
   def veta6 = <Veta6 
			dan_vrac="0"
			dan_zocelk="0"
			dano="0" 
			dano_da="0"
			dano_no={dano_no}
      odp_zocelk={odp_zocelk} />

  
}