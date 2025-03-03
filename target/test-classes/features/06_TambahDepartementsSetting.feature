
Feature:Tambah Departements Setting
#  Scenario: Login Ke Website Hadir
#    Given Pengguna membuka halaman login Hadir
#    When Pengguna memasukkan email "admin@hadir.com" dan password "admin@hadir"
#    And Pengguna menekan tombol login
#    Then Pengguna berhasil masuk ke halaman utama

  @positive @unitSetting
  Scenario: Admin menambahkan departement baru
    Given Pengguna memasukkan email "admin@hadir.com" dan password "admin@hadir"
    And Admin tekan menu management
    And Admin klik sub menu unit setting
    When Admin tekan tombol tambahkan
    And Admin memilih pilihan Credit Card
    And Admin tekan tombol tambah
    Then Unit setting berhasil ditambahkan


