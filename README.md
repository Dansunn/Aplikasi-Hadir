## 📌 Deskripsi
Proyek ini merupakan pengujian otomatis untuk aplikasi **Hadir** (Mobile & Web) menggunakan **Selenium** dan **Cucumber BDD**. Pengujian dilakukan berdasarkan spesifikasi yang dijelaskan dalam **Functional Specification Document (FSD)**.

## 📂 Struktur Pengujian
Pengujian mencakup berbagai fitur aplikasi Hadir, termasuk:
1. **Login** - Verifikasi kredensial pengguna.
2. **Dashboard** - Menampilkan informasi absensi dan status kehadiran.
3. **Absen Masuk** - Menguji proses absensi masuk.
4. **Absen Keluar** - Menguji proses absensi keluar.
5. **Koreksi Absen** - Menguji fitur koreksi absensi.
6. **Menu Izin** - Menguji proses izin karyawan.
7. **Menu Laporan** - Menguji tampilan dan filter data laporan absensi.

## ⚙️ Teknologi yang Digunakan
- **Java** - Bahasa pemrograman utama.
- **Selenium WebDriver** - Untuk otomatisasi browser.
- **Cucumber BDD** - Untuk skenario pengujian berbasis **Gherkin**.
- **TestNG** - Untuk eksekusi dan laporan pengujian.
- **Maven** - Untuk manajemen dependensi.

## 📊 Hasil Pengujian
Laporan pengujian tersedia dalam format **HTML** menggunakan **ExtentReports**. Ringkasan hasil:
- **Total Skenario:** 30
- **Sukses:** ✅ 90%
- **Gagal:** ❌ 10%
- **Fitur yang diuji:** Login, Absen, Koreksi, Izin, dan Laporan.

## 🚀 Cara Menjalankan Pengujian
1. Pastikan **Java** dan **Maven** sudah terinstal.
2. Jalankan perintah berikut:
   ```sh
   mvn clean tes

## Hasil Pengujian Menggunakan Extent Reports
![Screenshot 2025-03-03 211214](https://github.com/user-attachments/assets/2f8f20d1-c6d5-4ec4-b6d2-e60d839d98e7)
