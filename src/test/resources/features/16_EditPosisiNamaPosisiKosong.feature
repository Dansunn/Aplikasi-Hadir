Feature:Tambah Posisi

  @negative @posisi
  Scenario: Admin mengedit posisi
    Given pengguna10 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And klik menu management!
    And Pengguna klik sub menu posisi.
    When Admin tekan titik tiga pada posisi yang akan diedit
    And Admin tekan edit
    And Admin mengosongkan nama posisi
    And Admin klik tombol simpan
    Then Posisi gagal diedit