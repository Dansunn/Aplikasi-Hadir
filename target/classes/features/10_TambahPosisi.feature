Feature:Tambah Posisi

  @positive @posisi
    Scenario: Admin menambahkan posisi baru
      Given pengguna4 login dengan email "admin@hadir.com" dan password "admin@hadir"
      And Admin klik menu management
      And Admin klik sub menu posisi
      When Admin menekan tombol tambahkan
      And Admin mengisi posisi Admin 1
      And Admin memilih pilihan departement Credit Card
      And Admin menekan tombol tambah
      Then Posisi berhasil ditambahkan