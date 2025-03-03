Feature:Tambah Posisi

  @positive @posisi
  Scenario: Admin mengedit posisi
    Given pengguna9 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And tekan menu management
    And Pengguna tekan sub menu posisi
    When Admin klik titik tiga pada posisi yang akan diedit
    And Admin klik edit
    And Admin mengedit Admin 1 menjadi Admin 2
    And Admin menekan tombol simpan
    Then List yang diperbaharui menjadi "Admin 2"