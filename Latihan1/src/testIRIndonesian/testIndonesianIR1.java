/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testIRIndonesian;

import latihan1Test.*;
import java.util.ArrayList;
import latihan1Model.Document;
import latihan1Model.InvertedIndex;
import latihan1Model.Posting;
import latihan1Model.Term;

/**
 *
 * @author admin
 */
public class testIndonesianIR1 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Selasa 07 Mei 2019, 11:36 WIB\n"
                + "Serius Pindahkan Ibu Kota, Jokowi Bertolak ke Kalimantan\n"
                + "Ray Jordan - detikNews\n"
                + "Share 0Tweet Share 00 komentar\n"
                + "Serius Pindahkan Ibu Kota, Jokowi Bertolak ke Kalimantan\n"
                + "Presiden Jokowi (Foto: Andhika Prasetya/detikcom)\n"
                + "Jakarta - Presiden Joko Widodo (Jokowi) hari ini bertolak ke Kota Balikpapan, Kalimantan Timur. Jokowi hendak meninjau kota tersebut sebagai tindak lanjut keseriusan pemerintah dalam hal pemindahan ibu kota negara Republik Indonesia.\n"
                + "\n"
                + "Informasi yang disampaikan Deputi Bidang Protokol, Pers dan Media Sekretariat Presiden Bey Machmudin, Jokowi bertolak ke Balikpapan melalui Pangkalan TNI AU Halim Perdanakusuma, Jakarta Timur, Selasa (7/5/2019) pukul 09.00 WIB. Jokowi menumpangi Pesawat Kepresidenan Indonesia-1.\n"
                + "\n"
                + "\n"
                + "Baca juga: Pemerintah-DPR Segera Bahas Pemindahan Ibu Kota\n"
                + "\n"
                + "\n"
                + "\"Setibanya di Kota Balikpapan, Provinsi Kalimantan Timur, pada pukul 11.55 Wita, Presiden Jokowi langsung menuju ke lokasi yang menjadi alternatif rencana pemindahan ibu kota tersebut,\" kata Bey.\n"
                + "\n"
                + "Setelah Balikpapan, pada sore harinya Presiden Jokowi beserta rombongan akan melanjutkan perjalanan menuju Provinsi Kalimantan Tengah. Jokowi akan bermalam di Kota Palangkaraya.\n"
                + "\n"
                + "\"Presiden bermalam di Kota Palangkaraya untuk melanjutkan rangkaian kunjungan kerja keesokan harinya. Di antaranya meninjau lokasi yang menjadi alternatif rencana pemindahan ibu kota,\" kata Bey.\n"
                + "\n"
                + "Sebelumnya, di hadapan para kepala lembaga tinggi negara saat acara buka puasa bersama di Istana Negara, Jakarta, Senin (6/5) kemarin, Jokowi menegaskan pemerintah serius terkait rencana pemindahan ibu kota negara.\n"
                + "\n"
                + "\n"
                + "Baca juga: Jokowi Ingin Pindahkan Ibu Kota Negara, Fahri Hamzah Usul ke Pulau Seribu\n"
                + "\n"
                + "\n"
                + "\"Kita serius dalam hal ini karena sejak 3 tahun yang lalu sebetulnya ini telah kita bahas internal. Kemudian 1,5 tahun yang lalu kami minta Bappenas untuk melakukan kajian-kajian yang lebih detail baik dari sisi ekonomi, sosial politik, dan juga dari sisi lingkungan,\" ujar Presiden.\n"
                + "\n"
                + "Turut mendampingi Presiden Jokowi dalam penerbangan menuju Provinsi Kalimantan Timur adalah Sekretaris Kabinet Pramono Anung, Menteri Pekerjaan Umum dan Perumahan Rakyat Basuki Hadimuljono, Menteri PPN/ Kepala Bappenas Bambang Brodjonegoro, Menteri Agraria dan Tata Ruang/ Kepala BPN Sofyan A. Djalil, Sekretaris Militer Presiden Marsda TNI Trisno Hendradi, dan Komandan Paspampres Mayjen TNI Maruli Simanjutak.");
        Document doc2 = new Document(2, "Hendropriyono: Rizieq dan Keturunan Arab Jangan Memprovokasi Revolusi!\n"
                + "Elvan Dany Sutrisno - detikNews\n"
                + "Share 0Tweet Share 01 komentar\n"
                + "Hendropriyono: Rizieq dan Keturunan Arab Jangan Memprovokasi Revolusi!\n"
                + "Foto: Rachman Haryanto\n"
                + "Jakarta - Eks Kepala BIN AM Hendropriyono mengingatkan sejumlah WNI keturunan Arab tidak menjadi provokator. Hendropriyono tak mau seruan makar itu meluas.\n"
                + "\n"
                + "\"Saya peringatkan Rizieq, Yusuf Martak, dan orang-orang yang meneriakkan revolusi kan sudah banyak. Itu inkonstitusional, merusak disiplin dan tata tertib sosial, jangan seperti itu,\" kata Hendropriyono kepada wartawan, Selasa (7/5/2019).\n"
                + "\n"
                + "Hendropriyono memandang banyak warga keturunan arab yang sangat dihormati di masyarakat. Karena itu dia merasa perlu memperingatkan sebagian warga keturunan Arab untuk tidak memprovokasi revolusi sampai turun ke jalan.\n"
                + "\n"
                + "\"Kalau kenyataan di masyarakat kita itu sangat menghormati orang-orang Arab, mereka kan juga warga negara Indonesia. Kalau di kampung-kampung kita masih bisa lihat orang Arab datang ke kampung-kampung pada cium tangan. Berarti posisinya mereka kan berada pada tempat yang dimulyakan, mereka kemudian langsung atau tidak langsung terakui sebagai pemimpin informal, informal leader,\" kata Hendropriyono.\n"
                + "\n"
                + "Dengan posisi yang mulia seperti itu, Hendro mengimbau agar para warga keturUnan Arab supaya mengayomi masyarakat. \"Jangan malah memprovokasi revolusi, memprovokasi untuk turun melakukan gerakan politik jalanan. itu inkonstitusional,\" ingatnya lagi.\n"
                + "Baca juga: Pesan Tegas Wiranto Usut Para Penghasut\n"
                + "\n"
                + "Hendropriyono menyebut keturunan Arab juga berjuang untuk Republik Indonesia, demikian juga warga keturunan China. Ia menegaskan peringatan ini tidak ada tendensi SARA.\n"
                + "\n"
                + "\"Nenek moyang saya juga ada arabnya juga, saya nasionalis, saya tidak membenci mereka. Tidak ada urusan SARA, saya justru mengingatkan mereka itu punya peran penting di masyarakat,\" kata Hendropriyono.\n"
                + "\n"
                + "Ia lantas mengapresiasi sejumlah tokoh keturunan Arab yang dihormati dan sangat berperan di Indonesia. Menurutnya lebih banyak warga keturunan Arab yang mengabdi di tengah masyarakat.\n"
                + "\n"
                + "\"Ada Muhammad Ali Al Khatiri dia mendirikan organisasi Hadromi yang membikin para pemimpin umat membawa kepada kesejukan bukan untuk revolusi. Organisasi seperti ini yang mengangkat martabat orang-orang arab jangan dirusak yang sedikit. Yang sedikit itu tidak mungkin bisa merusak Republik Indonesia, tapi kalau yang banyak ini diam saja, bisa rusak,\" kata Hendropriyono.\n"
                + "\n"
                + "\"Saya tidak bisa diam saja, kalau saya punya kekuasaan saya kerjakan dengan tangan saya. Tapi saya sudha tua jadi saya pakai mulut saya, kalau saya lebih tua lagi saya pakai doa saja,\" pungkasnya.");
        Document doc3 = new Document(3, "Selasa, 07 Mei 2019 07:20 WIB\n"
                + "Jokowi Sudah Teken PP, Ini Daftar Penerima THR\n"
                + "Achmad Dwi Afriyadi - detikFinance\n"
                + "Share 0Tweet 0Share 035 komentar\n"
                + "Halaman 1 dari 3    \n"
                + "Foto: Tim Infografis: Fuad Hasim\n"
                + "Foto: Tim Infografis: Fuad Hasim\n"
                + "Jakarta - Kabar gembira untuk para Pegawai Negeri Sipil (PNS). Sebab, Tunjangan Hari Raya (THR) tahun ini dipastikan cair di akhir Mei.\n"
                + "\n"
                + "THR ini bakal cair pada 24 Mei 2019. Kepastian itu didapat setelah Presiden Joko Widodo (Jokowi) meneken Peraturan Pemerintah (PP) sebagai payung hukum kebijakan THR.\n"
                + "\n"
                + "\"PP-nya, Bapak Presiden sudah tanda tangan tadi,\" kata Menteri Keuangan Sri Mulyani Indrawati di Istana Negara, Jakarta Pusat, Senin (6/5/2019).\n"
                + "\n"
                + "Lalu, berapa besarannya THR? Siapa saja yang dapat? Berikut berita selengkapnya dirangkum detikFinance:");

        InvertedIndex index = new InvertedIndex();
        // lakukan stemming untuk semua dokumen
        doc1.IndonesiaStemming();
        doc2.IndonesiaStemming();
        doc3.IndonesiaStemming();
        System.out.println(doc1);
        // tmbahkan document ke index
//        index.addNewDocument(doc1);
//        index.addNewDocument(doc2);
//        index.addNewDocument(doc3);
        // bikin dictionary
        index.makeDictionaryWithTermNumber();
    }
}
