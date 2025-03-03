Feature:Tambah Posisi
  @negative @posisi
  Scenario: Admin menambahkan posisi baru
    Given pengguna5 login dengan email "admin@hadir.com" dan password "admin@hadir"
    Given klik menu management.
    And Admin tekan sub menu posisi
    When tekan tombol tambahkan
    And Admin pilih pilihan departement Credit Card
    And tekan tombol tambah
    Then Posisi gagal ditambahkan