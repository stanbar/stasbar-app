export interface Publication {
  title: string;
  link: string;
  what: string;
  when: string;
  where: string;
}
const publications: Publication[] = [
  {
    title: "Practical I-Voting on Stellar Blockchain",
    link: "https://www.mdpi.com/2076-3417/10/21/7606",
    what: "Article",
    when: "October 2020",
    where: "Applied Science"
  },
  {
    title:
      "Application of blockchain and infection processes in graphs to mitigate content poisoning attacks in information-centric network",
    link:
      "https://www.researchgate.net/publication/344659633_Application_of_blockchain_and_infection_processes_in_graphs_to_mitigate_content_poisoning_attacks_in_information-centric_networks",
    what: "Master Thesis",
    when: "October 2020",
    where: "Gdansk University of Technology"
  },
  {
    title:
      "Bitcoin cryptographic currency wallet with multifactor hybrid hardware-network authenticatio",
    what: "Engineering Thesis",
    link:
      "https://www.researchgate.net/publication/332472195_Bitcoin_cryptographic_currency_wallet_with_multifactor_hybrid_hardware-network_authentication",
    when: "April 2018",
    where: "Gdansk University of Technology"
  },
  {
    title: "How Android Boots Up",
    link: "https://proandroiddev.com/how-android-boot-up-9864376d911c",
    what: "Post",
    when: "October, 2018",
    where: "ProAndroidDev"
  }
];

export default publications;
