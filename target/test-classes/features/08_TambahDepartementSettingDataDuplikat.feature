Feature:Tambah Departements Setting Data Duplikat

  @negative @unitSetting
  Scenario: Admin menambahkan departement baru dengan data duplikat
    Given login dengan email "admin@hadir.com" dan password "admin@hadir"
    And tekan menu management
    And tekan sub menu unit setting
    When klik tombol tambahkan
    And pilih pilihan Credit Card
    And klik tombol tambah
    Then gagal ditambahkan