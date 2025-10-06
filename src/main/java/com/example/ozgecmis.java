package com.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class ozgecmis {

    public static void main(String[] args) {
        try {
            // PDF dokümanı oluştur - UTF-8 encoding ile
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("ozgecmis.pdf"));
            document.open();

            // TÜRKÇE KARAKTERLER İÇİN FONT AYARI
            // Windows'ta Arial fontunu kullan
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font turkceFont = new Font(baseFont, 12);
            Font turkceBaslikFont = new Font(baseFont, 18, Font.BOLD);
            Font turkceAltBaslikFont = new Font(baseFont, 14, Font.BOLD);

            // BAŞLIK
            Paragraph baslik = new Paragraph("ÖZGEÇMİŞ", turkceBaslikFont);
            baslik.setAlignment(Element.ALIGN_CENTER);
            baslik.setSpacingAfter(20);
            document.add(baslik);

            // TABLO OLUŞTUR (Fotoğraf ve Kişisel Bilgiler yan yana)
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingAfter(20);

            // 1. SUTUN: FOTOĞRAF
            try {
                Image foto = Image.getInstance("profil_foto.png");
                foto.scaleToFit(120, 150);
                PdfPCell fotoCell = new PdfPCell(foto);
                fotoCell.setBorder(Rectangle.NO_BORDER);
                fotoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(fotoCell);

            } catch (Exception e) {
                System.out.println("⚠️  Fotoğraf yüklenemedi: " + e.getMessage());
                PdfPCell bosCell = new PdfPCell(new Paragraph("Fotoğraf\nYüklenemedi", turkceFont));
                bosCell.setBorder(Rectangle.NO_BORDER);
                bosCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(bosCell);
            }

            // 2. SUTUN: KİŞİSEL BİLGİLER
            Paragraph bilgilerBaslik = new Paragraph("KİŞİSEL BİLGİLER", turkceAltBaslikFont);
            Paragraph adSoyad = new Paragraph("Ad Soyad: Feyza Nur Erbaş", turkceFont);
            Paragraph telefon = new Paragraph("Telefon: 0555 123 45 67", turkceFont);
            Paragraph eposta = new Paragraph("E-posta: 1240505044@gmail.com", turkceFont);
            Paragraph adres = new Paragraph("Adres: İstanbul, Türkiye", turkceFont);
            Paragraph linkedin = new Paragraph("LinkedIn: linkedin.com/in/feyzanur", turkceFont);

            PdfPCell bilgilerCell = new PdfPCell();
            bilgilerCell.setBorder(Rectangle.NO_BORDER);
            bilgilerCell.addElement(bilgilerBaslik);
            bilgilerCell.addElement(new Paragraph(" "));
            bilgilerCell.addElement(adSoyad);
            bilgilerCell.addElement(telefon);
            bilgilerCell.addElement(eposta);
            bilgilerCell.addElement(adres);
            bilgilerCell.addElement(linkedin);
            table.addCell(bilgilerCell);

            document.add(table);

            // EĞİTİM
            document.add(new Paragraph("EĞİTİM", turkceAltBaslikFont));
            document.add(new Paragraph("Üniversite: Kırklareli Üniversitesi", turkceFont));
            document.add(new Paragraph("Bölüm: Yazılım Mühendisliği", turkceFont));
            document.add(new Paragraph("Sınıf: 2. Sınıf", turkceFont));
            document.add(new Paragraph("Ortalama: 3.20/4.00", turkceFont));
            document.add(new Paragraph(" "));

            // İŞ DENEYİMLERİ
            document.add(new Paragraph("İŞ DENEYİMLERİ", turkceAltBaslikFont));

            // 1. İş Deneyimi
            document.add(new Paragraph("Stajyer Yazılım Geliştirici", new Font(baseFont, 12, Font.BOLD)));
            document.add(new Paragraph("ABC Teknoloji Şirketi | Haziran 2024 - Ağustos 2024", turkceFont));
            document.add(new Paragraph("- Java ve Spring Boot kullanarak web uygulamaları geliştirme", turkceFont));
            document.add(new Paragraph("- Veritabanı tasarımı ve SQL sorguları yazma", turkceFont));
            document.add(new Paragraph("- Takım içi kod review süreçlerine katılma", turkceFont));
            document.add(new Paragraph(" "));

            // 2. İş Deneyimi
            document.add(new Paragraph("Part-time Frontend Geliştirici", new Font(baseFont, 12, Font.BOLD)));
            document.add(new Paragraph("XYZ Startup | Eylül 2024 - Devam", turkceFont));
            document.add(new Paragraph("- HTML, CSS, JavaScript kullanarak arayüz geliştirme", turkceFont));
            document.add(new Paragraph("- React.js öğrenme ve basit component'lar oluşturma", turkceFont));
            document.add(new Paragraph("- Müşteri feedback'lerine göre arayüz iyileştirmeleri", turkceFont));
            document.add(new Paragraph(" "));

            // 3. İş Deneyimi
            document.add(new Paragraph("Gönüllü Proje Yöneticisi", new Font(baseFont, 12, Font.BOLD)));
            document.add(new Paragraph("Üniversite Teknoloji Kulübü | Ekim 2024 - Devam", turkceFont));
            document.add(new Paragraph("- Öğrenci projelerinin koordinasyonunu sağlama", turkceFont));
            document.add(new Paragraph("- Haftalık toplantılar düzenleme ve takvim yönetimi", turkceFont));
            document.add(new Paragraph("- Sosyal medya hesaplarının yönetimi", turkceFont));
            document.add(new Paragraph(" "));

            // BECERİLER
            document.add(new Paragraph("BECERİLER", turkceAltBaslikFont));
            document.add(new Paragraph("Programlama: Java, Python, JavaScript", turkceFont));
            document.add(new Paragraph("Web: HTML, CSS, React.js, Spring Boot", turkceFont));
            document.add(new Paragraph("Veritabanı: MySQL, PostgreSQL", turkceFont));
            document.add(new Paragraph("Araçlar: Git, IntelliJ, VS Code", turkceFont));
            document.add(new Paragraph("Diller: Türkçe (Ana dil), İngilizce (Orta seviye)", turkceFont));

            document.close();
            System.out.println("✅ Özgeçmişiniz başarıyla oluşturuldu: ozgecmis.pdf");

        } catch (Exception e) {
            System.out.println("❌ Hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}