Feature: Pengujian Fitur Aplikasi Hadir

    @Import
    Scenario: Menguji Upload File dalam Import Status
        Given Pengguna login ke website Hadir dengan email "admin@hadir.com" dan password "admin@hadir"
        And Pengguna menekan tombol menu Import di bagian kiri menu
        And Pengguna menekan tombol submenu Import Status Aktif
        When Pengguna menekan tombol choose file dan memilih file excel yang diinginkan
        And Pengguna menekan tombol import
        Then Muncul sebuah notifikasi "Berhasil import excel"

    @Import
    Scenario: Menguji Upload File dalam Import Status (Selain Excel)
        Given Pengguna menekan tombol choose file dan memilih file bukan excel
        And Pengguna menekan tombol import lagi
        Then Muncul notifikasi error "*File harus berupa file Excel (.xls atau .xlsx)"

    @Import
    Scenario: Mendownload File Template Untuk Data Import
        Given Pengguna menekan tombol download template
        Then Pengguna berhasil mendownload file template

    @Import
    Scenario: Menguji Upload File Excel Kosongan dalam Import Status
        Given Pengguna2 menekan tombol menu Import di bagian kiri menu
        And Pengguna2 menekan tombol submenu Import Status Aktif
        When Pengguna2 menekan tombol choose file dan memilih file excel kosongan
        And Pengguna2 menekan tombol import
        Then Muncul alert ""
