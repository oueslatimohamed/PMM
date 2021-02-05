package fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myspace.DetailActivity;
import com.example.myspace.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import adapter.PlanetAdapter;
import model.Planet;
import services.DatabasHelper;


public class HomeFragment extends Fragment implements View.OnClickListener {
    List<Planet> mPlanets ;
    ArrayList <Planet> planets;
    RecyclerView mRecyclerview;
    DatabasHelper databasHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerview = (RecyclerView) view.findViewById(R.id.home_recycle_view);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        databasHelper = new DatabasHelper(getContext());


        mPlanets = databasHelper.getAllPlanet();
        //Log.i("Home fragment" , String.valueOf(mPlanets.size()));
        databasHelper.addPlanet(new Planet(
                1,
                "Soleil" ,
                "Le Soleil est l’étoile du Système solaire. Dans la classification astronomique, c’est une étoile de type naine jaune d'une masse d'environ 1,989 1 × 1030 kg, composée d’hydrogène (75 % de la masse ou 92 % du volume) et d’hélium (25 % de la masse ou 8 % du volume)10. Le Soleil fait partie de la galaxie appelée la Voie lactée et se situe à environ 8 kpc (∼26 100 a.l.) du centre galactique, dans le bras d'Orion. Le Soleil orbite autour du centre galactique en 225 à 250 millions d'années (année galactique). Autour de lui gravitent la Terre (à la vitesse de 30 km/s), sept autres planètes, au moins cinq planètes naines, de très nombreux astéroïdes et comètes et une bande de poussière. Le Soleil représente à lui seul environ 99,854 % de la masse du Système solaire ainsi constitué, Jupiter représentant plus des deux tiers du reste.",
                "#f6d300",
                R.drawable.sun));
        databasHelper.addPlanet(new Planet(
                2,
                "Mercure" ,
                "Mercure est la planète la plus proche du Soleil et la moins massive du Système solaireN 1. Son éloignement au Soleil est compris entre 0,31 et 0,47 unité astronomique (soit 46 et 70 millions de kilomètres), ce qui correspond à une excentricité orbitale de 0,2 — plus de douze fois supérieure à celle de la Terre, et de loin la plus élevée pour une planète du Système solaire. Elle est visible à l'œil nu depuis la Terre avec un diamètre apparent de 4,5 à 13 secondes d'arc, et une magnitude apparente de 5,7 à −2,3 ; son observation est toutefois rendue difficile par son élongation toujours inférieure à 28,3° qui la noie le plus souvent dans l'éclat du soleil. En pratique, cette proximité avec le soleil implique qu'elle ne peut être vue que près de l'horizon occidental après le coucher du soleil ou près de l'horizon oriental avant le lever du soleil, en général au crépuscule. Mercure a la particularité d'être en résonance spin-orbite 3:2, sa période de révolution (~88 jours) valant exactement 1,5 fois sa période de rotation (~59 jours), et donc la moitié d'un jour solaire (~176 jours). Ainsi, relativement aux étoiles fixes, elle tourne sur son axe exactement trois fois toutes les deux révolutions autour du Soleil.",
                "#444422",
                R.drawable.mercure));
        databasHelper.addPlanet(new Planet(
                3,
                "Vénus" ,
                "Vénus est la deuxième planète du Système solaire par ordre d'éloignement au Soleil, et la sixième plus grosse aussi bien par la masse que le diamètre. Elle doit son nom à la déesse romaine de l'amour.  Vénus orbite autour du Soleil tous les 224,7 jours terrestres. Avec une période de rotation de 243 jours terrestres, il lui faut plus de temps pour tourner autour de son axe que toute autre planète du Système solaire. Comme Uranus, elle possède une rotation rétrograde et tourne dans le sens opposé à celui des autres planètes : le soleil s'y lève à l'ouest et se couche à l'est. Vénus possède l'orbite la plus circulaire des planètes du Système solaire avec une excentricité orbitale presque nulle et, du fait de sa lente rotation, est quasiment sphérique (aplatissement considéré comme nul). Elle ne possède pas de satellite naturel.",
                "#09b20c",
                R.drawable.venus));
        databasHelper.addPlanet(new Planet(
                4,
                "Terre" ,
                "La Terre est la troisième planète par ordre d'éloignement au Soleil et la cinquième plus grande du Système solaire aussi bien par la masse que le diamètre. Par ailleurs, elle est le seul objet céleste connu pour abriter la vie. Elle orbite autour du Soleil en 365,256 jours solaires — une année sidérale — et réalise une rotation sur elle-même relativement au Soleil en 23 h 56 min 4 s — un jour sidéral — soit un peu moins que son jour solaire de 24 h du fait de ce déplacement autour du Soleila. L'axe de rotation de la Terre possède une inclinaison de 23°, ce qui cause l'apparition des saisons.",
                "#f4f4f2",
                R.drawable.earth));
        databasHelper.addPlanet(new Planet(
                5,
                "Mars" ,
                "Mars (prononcé en français : /maʁs/) est la quatrième planète par ordre croissant de la distance au Soleil et la deuxième par ordre croissant de la taille et de la masse. Son éloignement au Soleil est compris entre 1,381 et 1,666 UA (206,6 à 249,2 millions de kilomètres), avec une période orbitale de 669,58 jours martiens (686,71 jours ou 1,88 années terrestres).  C’est une planète tellurique, comme le sont Mercure, Vénus et la Terre, environ dix fois moins massive que la Terre mais dix fois plus massive que la Lune. Sa topographie présente des analogies aussi bien avec la Lune, à travers ses cratères et ses bassins d'impact, qu'avec la Terre, avec des formations d'origine tectonique et climatique telles que des volcans, des rifts, des vallées, des mesas, des champs de dunes et des calottes polaires. Le plus haut volcan du Système solaire, Olympus Mons (qui est un volcan bouclier), et le plus grand canyon, Valles Marineris, se trouvent sur Mars.",
                "#ff0d00",
                R.drawable.mars));
        databasHelper.addPlanet(new Planet(
                6,
                "Jupiter" ,
                "Jupiter est une planète géante gazeusea. Il s'agit de la plus grosse planète du Système solaire, plus volumineuse et massive que toutes les autres planètes réunies, et la cinquième planète par sa distance au Soleil (après Mercure, Vénus, la Terre et Mars).  Jupiter est ainsi officiellement nommée1, en français comme en anglaisb, d'après le dieu romain Jupiter2, assimilé au dieu grec Zeus.",
                "#fda600",
                R.drawable.jupiter));
        databasHelper.addPlanet(new Planet(
                7,
                "Saturne" ,
                "Saturne est la sixième planète du Système solaire par ordre d'éloignement au Soleil et la deuxième plus grande par la taille et la masse après Jupiter, qui est comme elle une planète géante gazeuse. Son rayon moyen de 58 232 km est environ neuf fois et demi celui de la Terre et sa masse de 568,46 × 1024 kg est 95 fois plus grande. Orbitant en moyenne à environ 1,4 milliard de kilomètres du Soleil (9,5 unités astronomiques), sa période de révolution vaut un peu moins de 30 années tandis que sa période de rotation est estimée à 10 h 33 min.",
                "#9f9f9f",
                R.drawable.saturn));
        databasHelper.addPlanet(new Planet(
                8,
                "Uranus" ,
                "Uranus est la septième planète du Système solaire par ordre d'éloignement au Soleil. Elle orbite autour de celui-ci à une distance d'environ 19,2 unités astronomiques (2,87 milliards de kilomètres), avec une période de révolution de 84,05 années terrestres. Il s'agit de la quatrième planète la plus massive du Système solaire et de la troisième plus grande par la taille.  Elle est la première planète découverte à l’époque moderne avec un télescope et non connue depuis l'Antiquité. Bien qu'elle soit visible à l’œil nu, son caractère planétaire n'est alors pas identifié en raison de son très faible éclat et de son déplacement apparent dans le ciel très lent. William Herschel l'observe pour la première fois le 13 mars 1781 et la confirmation qu'il s'agit d'une planète et non d'une comète est faite pendant les mois qui suivent.",
                "#26efff",
                R.drawable.uranus));
        databasHelper.addPlanet(new Planet(
                9,
                "Neptune" ,
                "Neptune est la huitième planète par ordre d'éloignement au Soleil et la plus éloignée connue du Système solaireN 2. Elle orbite autour du Soleil à une distance d'environ 30,1 UA (4,5 milliards de kilomètres), avec une excentricité orbitale moitié moindre que celle de la Terre et une période de révolution de 164,79 ans. Il s'agit de la troisième planète la plus massive du Système solaire et la quatrième plus grande par la taille — un peu plus massive mais un peu plus petite qu'Uranus. Par ailleurs, elle est la planète géante la plus dense.",
                "#b026ee",
                R.drawable.neptune));
        databasHelper.addPlanet(new Planet(
                10,
                "Pluton" ,
                "Pluton, officiellement désigné par (134340) Pluton (désignation internationale : (134340) Pluto), est une planète naine, la plus volumineuse connue dans le Système solaire (2 372 km de diamètre, contre 2 326 km pour Éris), et la deuxième en ce qui concerne sa masse (après Éris). Pluton est ainsi le neuvième plus gros objet connu orbitant directement autour du Soleil et le dixième par la masse. Premier objet transneptunien identifié, Pluton orbite autour du Soleil à une distance variant entre 30 et 49 unités astronomiques et appartient à la ceinture de Kuiper, ceinture dont il est (tant par la taille que par la masse) le plus grand membre connu",
                "#000000",
                R.drawable.pluton));
        databasHelper.close();


        PlanetAdapter planetAdapter = new PlanetAdapter(getContext(),mPlanets,this::onClick);
        mRecyclerview.setAdapter(planetAdapter);
        return view;


    }

    @Override
    public void onClick(View view) {
        if (view.getTag() != null){
            //Log.i("Homefragment" , "OnClick jawek bhy " + getTag());
            showPlanetDetail((int) view.getTag());
        }

    }

    public void showPlanetDetail(int planetIndex) {
        Log.i("homefragment",mPlanets.get(planetIndex).getmName());
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_PLANET , mPlanets.get(planetIndex));
        //intent.putExtra(DetailActivity.EXTRA_INDEX , planetIndex);
        startActivity(intent);

    }
}