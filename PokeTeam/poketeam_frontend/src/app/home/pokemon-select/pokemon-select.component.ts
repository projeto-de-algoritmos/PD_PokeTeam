import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {PokemonService} from '../services/pokemon.service';
import {Pokemons} from '../interfaces/pokemons';
import {MatSelectChange} from "@angular/material/select";
import {MatDialog} from "@angular/material/dialog";
import {PokemonNotFoundComponent} from "../pokemon-not-found/pokemon-not-found.component";
import { PokemonFoundComponent } from '../pokemon-found/pokemon-found.component';
import {Observable} from "rxjs";


@Component({
  selector: 'app-pokemon-select',
  templateUrl: './pokemon-select.component.html',
  styleUrls: ['./pokemon-select.component.css']
})
export class PokemonSelectComponent implements OnInit {

  list: Pokemons[] | undefined;
  imageAlt: any;
  imageSourceSelf: any;
  pokemon: any = null;
  pokemonForm = this.formBuilder.group({
    pokemon: '',
  });

  constructor(
    private pokemonService: PokemonService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog,
  ) {

  }

  ngOnInit(): void {
    this.pokemonService.listPokemons().forEach((pokemon)=> this.list = pokemon);
  }

  openDialogError(): void {
    const dialogRef = this.dialog.open(PokemonNotFoundComponent, {
      width: '500px',
      height: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  openDialog(response: any): void {
    const dialogRef = this.dialog.open(PokemonFoundComponent, {
      width: '700px',
      height: '500px',
      data: response,
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  find() {
    let selectedList: Array<Pokemons> = []

    console.log(this.list);

    this.list?.forEach((pokemon) => {
        if (pokemon.selected){
          selectedList.push(pokemon);
        }
    })


    this.pokemonService.bestTeam(selectedList).subscribe((response: any) => {
      this.openDialog(response);
      }, (error: any) => {
      this.openDialogError();
      }
    );
  }

  setSelected(pokemon: Pokemons) {
    pokemon.selected = !pokemon.selected
  }

  selectAll() {
    this.list?.forEach((pokemon) => {
      pokemon.selected = true;
    })
  }

  unselectAll() {
    this.list?.forEach((pokemon) => {
      pokemon.selected = false;
    })
  }
}
