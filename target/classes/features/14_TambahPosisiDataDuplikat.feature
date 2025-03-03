Feature:Tambah Posisi

  @negative @posisi
  Scenario: Admin menambahkan posisi baru
    Given pengguna8 login dengan email "admin@hadir.com" dan password "admin@hadir"
    And Pengguna klik menu management
    And Pengguna klik sub menu posisi
    When Pengguna menekan tombol tambahkan
    And Pengguna mengisi posisi Admin 1
    And Pengguna memilih pilihan departement Credit Card
    And Pengguna menekan tombol tambah
    Then Pengguna gagal menambahkan data