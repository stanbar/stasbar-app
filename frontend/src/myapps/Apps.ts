/*
 * Copyright 2019 Stanislaw Baranski @stasbar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */


import IApp from "./IApp";
import VapeToolLongFramedPng from "../assets/png/VapeTool/VapeToolLongFramed.png"
import GoLureLongFramedPng from "../assets/png/GoLure/GoLureLongFramed.png"
import Wallpapers4KLongFramedPng from "../assets/png/Wallpapers4K/Wallpapers4KLongFramed.png"
import WallpapersOneClickLongFramedPng from "../assets/png/WallpapersOneClick/WallpapersOneClickLongFramed.png"
import WishesLongFramedPng from "../assets/png/Wishes/WishesLongFramed.png"
import TaxLedgerFramedPng from "../assets/png/TaxLedger/TaxLedgerFramed.png"

import VapeToolLongFramedWebp from "../assets/webp/VapeTool/VapeToolLongFramed.webp"
import GoLureLongFramedWebp from "../assets/webp/GoLure/GoLureLongFramed.webp"
import Wallpapers4KLongFramedWebp from "../assets/webp/Wallpapers4K/Wallpapers4KLongFramed.webp"
import WallpapersOneClickLongFramedWebp from "../assets/webp/WallpapersOneClick/WallpapersOneClickLongFramed.webp"
import WishesLongFramedWebp from "../assets/webp/Wishes/WishesLongFramed.webp"
import TaxLedgerFramedWebp from "../assets/webp/TaxLedger/TaxLedgerFramed.webp"


const Apps: IApp[] = [
  {
    name: "Vape Tool",
    imgSrc: VapeToolLongFramedPng,
    imgWebp: VapeToolLongFramedWebp,
    description: `Fully fledged utility arsenal and social media for Vapers. Over 1M downloads and 300k active users`,
    platform: "mobile",
    links: {
      website: "https://vapetool.stasbar.com",
      github: null,
      googlePlay: "https://play.google.com/store/apps/details?id=com.stasbar.vape_tool",
      appStore: "https://itunes.apple.com/us/app/coil-builder/id1210289983?mt=8",
    }
  },
  {
    name: "Tax Ledger",
    imgSrc: TaxLedgerFramedPng,
    imgWebp: TaxLedgerFramedWebp,
    description: `Desktop application for settle taxes from cryptocurrencies exchanges`,
    platform: "desktop",
    links: {
      website: "https://tax-ledger.com",
      github: null,
      googlePlay: null,
      appStore: null,
    }
  },
  {
    name: "4K Wallpapers",
    imgSrc: Wallpapers4KLongFramedPng,
    imgWebp: Wallpapers4KLongFramedWebp,
    description: "High resolution wallpapers",
    platform: "mobile",
    links: {
      website: null,
      github: null,
      googlePlay: "https://play.google.com/store/apps/details?id=com.wallpapers.new_wallpapers4k",
      appStore: null,
    }
  },
  {
    name: "Go Lure",
    imgSrc: GoLureLongFramedPng,
    imgWebp: GoLureLongFramedWebp,
    description: "Catching the Pokemon Go hype, with addon scheduler for lure module party on a map",
    platform: "mobile",
    links: {
      website: null,
      github: null,
      googlePlay: "https://play.google.com/store/apps/details?id=com.stasbar.golure",
      appStore: null,
    }
  },
  {
    name: "Easy Wallpapers",
    imgSrc: WallpapersOneClickLongFramedPng,
    imgWebp: WallpapersOneClickLongFramedWebp,
    description: `Easy to use wallpaper apps build with many category flavors`,
    platform: "mobile",
    links: {
      website: null,
      github: null,
      googlePlay: "https://play.google.com/store/apps/details?id=com.david_wallpapers.city_night",
      appStore: null,
    }
  },
  {
    name: "Wishes",
    imgSrc: WishesLongFramedPng,
    imgWebp: WishesLongFramedWebp,
    description: `Wishes application for many occasion flavors`,
    platform: "mobile",
    links: {
      website: null,
      github: null,
      googlePlay: "https://play.google.com/store/apps/details?id=com.allwishes.christmas",
      appStore: null,
    }
  }
];

export default Apps
